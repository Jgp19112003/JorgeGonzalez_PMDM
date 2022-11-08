package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.spinner.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var arraySpinner: ArrayList<String>
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        instancias()
        asociarDatos()
        acciones()
        rellenarSpinner()
    }

    private fun asociarDatos() {
        binding.spinnerSencillo.adapter = adaptadorSencillo
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        //adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner)
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,R.array.paises,android.R.layout.simple_spinner_item)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun acciones() {
        /*binding.spinnerSencillo.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSencillo, i.toString(), Snackbar.LENGTH_SHORT)
        }*/
        binding.spinnerSencillo.onItemSelectedListener = this
    }

    private fun rellenarSpinner() {
        arraySpinner.add("España")
        arraySpinner.add("Brasil")
        arraySpinner.add("Alemania")
        arraySpinner.add("Francia")
        arraySpinner.add("Qatar")


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Snackbar.make(p1!!, p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}