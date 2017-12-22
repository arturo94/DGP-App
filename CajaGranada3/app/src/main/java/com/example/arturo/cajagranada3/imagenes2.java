package com.example.arturo.cajagranada3;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

/**
 * Created by arturo on 19/12/17.
 */

public class imagenes2 extends AppCompatActivity implements TextToSpeech.OnInitListener {

    String pieza;
    String localizacion;
    String texto;
    TextToSpeech t1; //variable del text to speech
    ImageView imagen;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        imagen= (ImageView) findViewById(R.id.imagen);
        pieza=getIntent().getExtras().getString("qr");
        localizacion=getIntent().getExtras().getString("localizacion");
        texto=getIntent().getExtras().getString("texto");
        t1 = new TextToSpeech(this, this);    //inicialización de variables
        info= (TextView) findViewById(R.id.desc);
        info.setText(texto);
    }


    @Override
    public void onInit(int status) {
        if(status != TextToSpeech.ERROR) {
            t1.setLanguage(Locale.getDefault());
        }

        Picasso.with(this)
                .load(localizacion)
                //.load("https://image.ibb.co/hQBSX6/ESCRITOR.jpg")
                .error(R.mipmap.ic_launcher)
                .fit()
                .centerInside()
                .into(imagen);
        t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onBackPressed()
    {
        t1.speak(" ", TextToSpeech.QUEUE_FLUSH, null);
        Intent reader = new Intent(imagenes2.this, ElementoReader.class);
        startActivity(reader);
        super.onBackPressed();  // Invoca al método
    }


}

