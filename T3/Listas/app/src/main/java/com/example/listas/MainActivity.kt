package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.example.listas.adapters.AdapterPais
import com.example.listas.databinding.ActivityMainBinding
import com.example.spinner.modelo.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayPaises: ArrayList<Pais>
    private lateinit var adaptadorSencillo: ArrayAdapter<Pais>
    private lateinit var adaptadorComplejo: AdapterPais
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancas()
        asociarDatos()
        acciones()
    }

    private fun acciones() {
        binding.listaPaises.setOnItemClickListener { adapterView, view, i, l ->
            var pais: Pais = adaptadorComplejo.getItem(i) as Pais
            Snackbar.make(view,"Numero de titulos ${pais.numeroTitulos}",
            Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun asociarDatos() {
    binding.listaPaises.adapter = adaptadorComplejo

    }

    private fun instancas() {
        arrayPaises = ArrayList()

        arrayPaises.add(Pais("España",R.drawable.espania,1,"Pedri"))
        arrayPaises.add(Pais("Brasil",R.drawable.brasil,5,"Neymar"))
        arrayPaises.add(Pais("Alemania",R.drawable.alemania,4,"Muller"))
        arrayPaises.add(Pais("Francia",R.drawable.francia,2,"Mbappe"))
        arrayPaises.add(Pais("Qatar",R.drawable.qatar,0,"Desconocido"))
        //adaptadorSencillo = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,arrayPaises)
        adaptadorComplejo = AdapterPais(arrayPaises,applicationContext)
    }
}