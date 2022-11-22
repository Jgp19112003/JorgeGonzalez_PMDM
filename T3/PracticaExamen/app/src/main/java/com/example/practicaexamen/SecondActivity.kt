package com.example.practicaexamen

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaexamen.databinding.ActivityMainBinding
import com.example.practicaexamen.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity()  {


    private lateinit var binding: SecondActivityBinding
    lateinit var arraySpinner: ArrayList<Lenguaje>
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        rellenarSpinnerPersonalizado()
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner,applicationContext)
    }

    private fun asociarDatos() {
        binding.spinnerAsignaturas.adapter = adaptadorPersonalizado
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add(Lenguaje("Python",R.drawable.pythonlogo))
        arraySpinner.add(Lenguaje("Java",R.drawable.javalogo))
        arraySpinner.add(Lenguaje("Kotlin",R.drawable.kotlinlogo))
        arraySpinner.add(Lenguaje("JavaScript",R.drawable.logojavascript))

    }
}