package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.spinner.adaptadores.AdaptadorPersonalizado
import com.example.spinner.databinding.ActivityMainBinding
import com.example.spinner.modelo.Pais
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {

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
        rellenarSpinnerPersonalizado()
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner,applicationContext)
    }

    private fun acciones() {
        /*binding.spinnerSencillo.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSencillo, i.toString(), Snackbar.LENGTH_SHORT)
        }*/
        binding.spinnerSencillo.onItemSelectedListener = this
        binding.spinnerComplejo.onItemSelectedListener = this
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add(Pais("España",R.drawable.espania,1,"Pedri"))
        arraySpinner.add(Pais("Brasil",R.drawable.brasil,5,"Neymar"))
        arraySpinner.add(Pais("Alemania",R.drawable.alemania,4,"Muller"))
        arraySpinner.add(Pais("Francia",R.drawable.francia,2,"Mbappe"))
        arraySpinner.add(Pais("Qatar",R.drawable.qatar,0,"Desconocido"))

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0?.id) {
            R.id.spinnerSencillo ->{

            }
            R.id.spinnerComplejo ->{
                binding.imagenEscudo.setImageResource((adaptadorPersonalizado.getItem(p2) as Pais).imagen )
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            binding.botonDetalles.id -> {
                (binding.spinnerComplejo.selectedItem as Pais).mostrarDetalles()

            }
        }
    }


}