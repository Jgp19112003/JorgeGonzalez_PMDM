package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textoPeso: TextView
    lateinit var textoAltura: TextView
    lateinit var textoSexo: TextView
    lateinit var botonEvaluar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("ciclo_vida", "Método onCreate ejecutado")
        textoPeso = findViewById(R.id.textoPeso)
        textoAltura = findViewById(R.id.textoAltura)
        textoSexo = findViewById(R.id.textoSexo)
        botonEvaluar = findViewById(R.id.botonEvaluar)
        botonEvaluar.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")

    }
}