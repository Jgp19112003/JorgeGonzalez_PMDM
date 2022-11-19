package com.example.hobbies

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.hobbies.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener, View.OnClickListener{

    private lateinit var binding: SecondActivityBinding
    lateinit var arraySpinner: ArrayList<String>
    lateinit var adaptadorSencillo: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        instancias()
        asociarDatos()
        acciones()
        rellenarSpinnerPersonalizado()

    }

    private fun asociarDatos() {
        binding.spinnerHobbies.adapter = adaptadorSencillo

    }

    private fun instancias() {
        arraySpinner = ArrayList()
        adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun acciones() {
        binding.spinnerHobbies.onItemSelectedListener = this
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add("Futbol")
        arraySpinner.add("Juegos")
        arraySpinner.add("Series")
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}