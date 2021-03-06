package com.example.arturo.cajagranada3;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturo on 19/12/17.
 */

public class Consulta extends AppCompatActivity {
    String pieza;
    List<Elemento> lista = new ArrayList<Elemento>();
    String JSON_STRING;
    String json_string;
    boolean bandera=false;

    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String JSON_URL;
        @Override
        protected void onPreExecute() {
            JSON_URL ="http://museodgp.sytes.net/JSON/bd.php";
            //JSON_URL ="http://192.168.1.121/bd.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                StringBuilder JSON_DATA = new StringBuilder();
                URL url = new URL(JSON_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while ((JSON_STRING = reader.readLine())!=null) {
                    JSON_DATA.append(JSON_STRING).append("\n");
                }
                return JSON_DATA.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            json_string=result;
            try {
                parseJSON();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);
        pieza=getIntent().getExtras().getString("pieza"); //recupera el string del qr
        getJson();
    }

    public void getJson(){
        new BackgroundTask().execute();
    }

    public void parseJSON() throws JSONException {
        JSONObject jsonObject;
        JSONArray jsonArray;

        String id="",categoria="",idioma="", elemento="",descripcion="",descripcion1="";

        if(json_string==null){
            Toast.makeText(getApplicationContext(),"First get json", Toast.LENGTH_LONG).show();
        }

        else{
            jsonObject=new JSONObject(json_string);
            jsonArray = jsonObject.optJSONArray("result"); //nombre del JSON
            int count=0;

            while (count<jsonArray.length()){
                JSONObject JO=jsonArray.getJSONObject(count);
                id=JO.getString("id");
                categoria=JO.getString("categoria");
                idioma=JO.getString("idioma");
                elemento=JO.getString("elemento");
                descripcion=JO.getString("descripcion");
                descripcion1=JO.getString("descripcion1");
                count++;
                lista.add(new Elemento(id,categoria,idioma,elemento,descripcion,descripcion1));
            }

            for (Elemento nombre: lista){
                if(pieza.equals(nombre.elemento)){
                    bandera=true;
                    //selecciona la clase a la que va
                    if(nombre.categoria.equals("2")) {
                        Intent reader = new Intent(Consulta.this, videoButton.class);
                        reader.putExtra("qr", nombre.elemento);
                        reader.putExtra("localizacion", nombre.descripcion);
                        startActivity(reader);
                    }
                    else{
                        if(nombre.categoria.equals("1")) {
                            Intent reader = new Intent(Consulta.this, imagenes2.class);
                            reader.putExtra("qr", nombre.elemento);
                            reader.putExtra("localizacion", nombre.descripcion);
                            reader.putExtra("texto", nombre.descripcion1);
                            startActivity(reader);
                        }
                    }

                }
            }

        }

        if(bandera==false) {
            Intent reader = new Intent(Consulta.this, ElementoReader.class);
            startActivity(reader);
            Toast.makeText(this, pieza+"Codigo Qr invalido", Toast.LENGTH_LONG).show();
        }

    }

}


