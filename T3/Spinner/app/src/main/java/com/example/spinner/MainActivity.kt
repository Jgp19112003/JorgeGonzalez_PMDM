package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.spinner.adaptadores.AdaptadorPersonalizado
import com.example.spinner.databinding.ActivityMainBinding
import com.example.spinner.modelo.Pais
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var arraySpinner: ArrayList<Pais>
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        instancias()
        asociarDatos()
        acciones()
        rellenarSpinnerPersonalizado()
    }

    private fun asociarDatos() {
        binding.spinnerSencillo.adapter = adaptadorSencillo
        binding.spinnerComplejo.adapter = adaptadorPersonalizado
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        //adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner)
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,R.array.paises,android.R.layout.simple_spinner_item)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner,applicationContext)
    }

    private fun acciones() {
        /*binding.spinnerSencillo.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSencillo, i.toString(), Snackbar.LENGTH_SHORT)
        }*/
        binding.spinnerSencillo.onItemSelectedListener = this
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add(Pais("España",R.drawable.espania))
        arraySpinner.add(Pais("Brasil",R.drawable.brasil))
        arraySpinner.add(Pais("Alemania",R.drawable.alemania))
        arraySpinner.add(Pais("Francia",R.drawable.francia))
        arraySpinner.add(Pais("Qatar",R.drawable.qatar))

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Snackbar.make(p1!!, p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}