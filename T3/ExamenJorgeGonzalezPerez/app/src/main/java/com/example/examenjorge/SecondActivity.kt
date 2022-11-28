package com.example.examenjorge

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.examenjorge.databinding.SecondActivityBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding
    lateinit var coches: ArrayList<Coche>
    lateinit var adaptadorLista: AdaptadorLista
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        instancias()

    }

    private fun instancias() {
        coches = ArrayList ()
        adaptadorLista = AdaptadorLista(coches,applicationContext)

        binding.listaModelos.adapter = adaptadorLista

        coches.add(Coche("Leon","Seat",2012,"Diesel",R.drawable.leon))

        binding.listaModelos.setOnItemClickListener { adapterView, view, i, l ->
            var coche: Coche = adaptadorLista.getItem(i) as Coche
            Snackbar.make(view, "Combustible: " + coche.combustible+" Año: " + coche.anio, Snackbar.LENGTH_SHORT).show()
        }
    }
}