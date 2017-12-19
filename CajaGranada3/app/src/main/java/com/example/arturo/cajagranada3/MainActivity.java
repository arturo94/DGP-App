package com.example.arturo.cajagranada3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    ImageButton reservacion;
    ImageButton ubicacion;
    ImageButton productos;
    Button scanner;
    ImageButton speechre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanner = (Button) findViewById(R.id.button1);
        //ubicacion = (ImageButton) findViewById(R.id.imageButton5);
        //productos = (ImageButton) findViewById(R.id.imageButton2);
        //reservacion = (ImageButton) findViewById(R.id.imageButton3);
        //speechre = (ImageButton) findViewById(R.id.imageButton4);

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reader = new Intent(MainActivity.this, nueva.class);
                startActivity(reader);
            }
        });

        /*reservacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent reservacion = new Intent(MainActivity.this, reserva.class);
               // startActivity(reservacion);
            }
        });

        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent ubicacion = new Intent(MainActivity.this, ubicacion.class);
                //startActivity(ubicacion);

            }
        });

        productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent productos = new Intent(MainActivity.this, productos.class);
                //startActivity(productos);

            }
        });

        speechre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent speech = new Intent(MainActivity.this, mainsalas.class);
                //startActivity(speech);
            }
        });*/


    }

    public void onStart(){
        super.onStart();

        /*EditText txtDate=(EditText)findViewById(R.id.txtdate);
        txtDate.setOnFocusChangeListener(new OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean hasfocus){
                if(hasfocus){
                    DateDialog dialog=new DateDialog(view);
                    FragmentTransaction ft =getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");

                }
            }

        });*/
    }

}
