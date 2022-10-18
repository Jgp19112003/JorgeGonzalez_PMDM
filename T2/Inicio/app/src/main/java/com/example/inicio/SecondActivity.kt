package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textoNombre: TextView
    lateinit var imagen_android: ImageView
    lateinit var nombreRecuperado: String
    var edadRecuperada: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        recuperarDartos()
        iniciarUI()
    }

    private fun iniciarUI(){
        textoNombre.setText(nombreRecuperado+" "+resources.getString(R.string.saludo_recuperado))
        imagen_android.setImageDrawable(resources.getDrawable(R.drawable.android2,null))
        Log.v("datos_recuperados",edadRecuperada.toString())
    }

    private fun recuperarDartos(){
        var bundleRecuperado: Bundle? = intent.extras
        nombreRecuperado = bundleRecuperado?.getString("nombre","por defecto").toString()
        edadRecuperada = bundleRecuperado?.getInt("edad",18) ?: 0
    }
    private fun instancias(){
        textoNombre = findViewById(R.id.textoNombre)
        imagen_android = findViewById(R.id.imagen_android)
    }
}