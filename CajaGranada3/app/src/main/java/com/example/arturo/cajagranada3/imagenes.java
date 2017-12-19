package com.example.arturo.cajagranada3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class imagenes extends AppCompatActivity {

    private int MY_DATA_CHECK_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String pieza=getIntent().getExtras().getString("pieza");
        String texto=getIntent().getExtras().getString("parametro");

        if(pieza.equals("Craneo")) {
            ImageView iv1 = (ImageView) findViewById(R.id.craneo);
            iv1.setVisibility(View.VISIBLE);
        }


    }

}
