package com.example.arturo.cajagranada3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by arturo on 15/12/17.
 */

public class videoButton extends AppCompatActivity {

    String pieza, texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_layout);

        pieza=getIntent().getExtras().getString("qr");
        texto=getIntent().getExtras().getString("localizacion");

        ImageButton scanner = (ImageButton) findViewById(R.id.imageButton3);

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //funcion para cambiar de pantalla
                Intent reader = new Intent(videoButton.this, video.class);
                reader.putExtra("qr", pieza);
                reader.putExtra("localizacion", texto);
                startActivity(reader);
            }
        });
    }

}