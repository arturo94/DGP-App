package com.example.arturo.cajagranada3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    Button scanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanner = (Button) findViewById(R.id.button1);

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //funcion para cambiar de pantalla
                Intent reader = new Intent(MainActivity.this, nueva.class);
                startActivity(reader);
            }
        });


    }

}
