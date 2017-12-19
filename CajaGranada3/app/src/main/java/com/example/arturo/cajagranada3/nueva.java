package com.example.arturo.cajagranada3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Locale;

public class nueva extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech t1;

    ImageButton scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        t1=new TextToSpeech(this, this);

        scan_btn = (ImageButton) findViewById(R.id.scan);

        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                if(result.getContents().equals("Craneo")) {
                    Scan("Craneo","Para los nahuas el morir era un constante renacer. El sacrificio humano y la guerra eran indispensables para el equilibrio del universo. Esta compleja visión de la muerte motivó a que representaran de manera constante calaveras, muertos, esculturas, cerámica, bajo relieves y tallas en piedra" );

                }


                else
                if(result.getContents().equals("Coatlicue")) {
                    Scan("Coatlicue", "Coatlicue en la mitología mexica es la diosa de la fertilidad, patrona de la vida y de la muerte, guía del renacimiento, la madre gestante de Huitzilopochtli, era venerada como la madre de los dioses, entre sus atributos era representada como una mujer usando una falda de serpientes. Tiene los pechos caídos, que simbolizan la fertilidad y un collar de manos y corazones humanos que fueron arrancados de las víctimas de sus sacrificios.");
                }

                else
                if(result.getContents().equals("Borgia")) {
                    Scan("Borgia", "El códice Borgia (o códice Yoalli Ehécatl) es un manuscrito mesoamericano de contenido ritual y adivinatorio. Se cree que fue escrito antes de la conquista de México, en algún lugar en el sur o el oeste del estado mexicano de Puebla.\n" +
                            "El códice está escrito sobre piel de animal plegada en 39 hojas. Cada hoja es un cuadrado de 27 cm por 27 cm (11 x 11 pulgadas), con una longitud total de casi 11 metros (35 pies). Todas las páginas menos la última están escritas e ilustradas por ambas caras, lo que supone 76 páginas con contenido. El códice se lee de derecha a izquierda.");
                }
                else
                if(result.getContents().equals("Virgen")) {
                    Scan("Virgen", "La Virgen de la buena Muerte, mejor conocida como la Virgen de la Cofradía de la Buena Muerte en Manresa España. Esta es la imagen con la cual se representa el momento de acompañamiento de María a su hijo después de su muerte. En España la veneran con el sentido de súplica por conseguir una muerte más benigna. Es una pieza procesional de tamaño promedio donde muestra una vestimenta en color negro símbolo de luto, en la mano derecha, un cráneo alusivo a la muerte, y en la mano izquierda un rosario.");
                   /*Intent reader = new Intent(nueva.this, imagenes.class);
                   reader.putExtra("parametro", "Virgen");
                   startActivity(reader);
                   t1.speak("La Virgen de la buena Muerte, mejor conocida como la Virgen de la Cofradía de la Buena Muerte en Manresa España. Esta es la imagen con la cual se representa el momento de acompañamiento de María a su hijo después de su muerte. En España la veneran con el sentido de súplica por conseguir una muerte más benigna. Es una pieza procesional de tamaño promedio donde muestra una vestimenta en color negro símbolo de luto, en la mano derecha, un cráneo alusivo a la muerte, y en la mano izquierda un rosario.", TextToSpeech.QUEUE_FLUSH, null);
                   Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();*/
                }
                else
                if(result.getContents().equals("Cristo")) {
                    Scan("Cristo", "La imagen por excelencia e históricamente antigua en el mundo cristiano fue la del culto donde el icono relevante fue el Cristo, una imagen contemplativa y con mensaje, un mensaje del dolor, pasión, y conmoción. \n" +
                            "Nuestra imagen del Cristo de madera traído desde Michoacán,  pasa a ser una imagen de culto, realizado en madera con incrustaciones de cristal en sus ojos. Llama la atención que este Cristo se encuentre sobre dos cruces, una en color rojo con imágenes florales denominada cruz mistilínea del siglo XVII. La otra cruz donde se encuentra la imagen del Cristo clavado es de color negro con imágenes representativas a la Cruz de la Pasión de Cristo.");
                }

                else
                if(result.getContents().equals("Pascualito")) {
                    Scan("Pascualito", "San Pascualito conocido también como San Pascualito Muerte y San Pascual Rey es un santo popular relacionado con San Pascual Baylón. Es venerado en Guatemala y el estado mexicano de Chiapas en forma de un esqueleto, tal vez llevando una capa o una corona. Es posible que las raíces de la tradición de San Pascualito daten de la época precolombina, y que él represente un dios de la muerte prehispánico. La Iglesia Católica no lo reconoce como santo y rechaza su veneración. ");
                }

               else
                if(result.getContents().equals("Video")) {
                    Intent reader2 = new Intent(nueva.this, video.class);
                    startActivity(reader2);
                    }


                else
                    Toast.makeText(this, "Qr no valido", Toast.LENGTH_LONG).show();

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void Scan(String nombre, String texto){
        Intent reader = new Intent(nueva.this, video.class);
        reader.putExtra("pieza", nombre);
        reader.putExtra("parametro", texto);
        startActivity(reader);
        t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
        //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInit(int status) {
        if(status != TextToSpeech.ERROR) {
            t1.setLanguage(Locale.getDefault());
        }
    }

    @Override
    public void onBackPressed()
    {
        // Añade más funciones si fuese necesario
        t1.speak(" ", TextToSpeech.QUEUE_FLUSH, null);
        super.onBackPressed();  // Invoca al método
    }
    
}

