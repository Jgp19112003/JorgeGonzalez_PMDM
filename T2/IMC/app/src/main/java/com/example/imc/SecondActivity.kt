package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textoIndice: TextView
    lateinit var textoIMC: TextView
    lateinit var textoEstado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
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