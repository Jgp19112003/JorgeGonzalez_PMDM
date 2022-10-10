package com.example.inicio


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView
    lateinit var texto_introducido: EditText
    lateinit var texto_cambiado: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonPulsar = findViewById(R.id.boton_pulsar)
        texto_introducido = findViewById(R.id.texto_introducido);
        textoSaludo = findViewById(R.id.texto_bienvenida);
        botonPulsar.setOnClickListener ({
            var texto = texto_introducido.text
            textoSaludo.setText(texto)
            texto_introducido.setText("")
            Log.v("ciclo_vida","Botón pulsado")

        })


    }
    override fun onStart() {
        super.onStart()

        botonPulsar = findViewById(R.id.boton_pulsar)
        Log.v("ciclo_vida","Método onStart ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
    }

    override fun onResume() {
        super.onResume()

        botonPulsar = findViewById(R.id.boton_pulsar)
        Log.v("ciclo_vida","Método onResume ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
    }

    override fun onPause() {
        super.onPause()

        botonPulsar = findViewById(R.id.boton_pulsar)
        Log.v("ciclo_vida","Método onPause ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
    }


}