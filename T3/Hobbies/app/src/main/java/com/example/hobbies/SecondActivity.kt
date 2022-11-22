package com.example.hobbies

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.hobbies.adapters.AdapterLista
import com.example.hobbies.databinding.SecondActivityBinding
import com.example.hobbies.model.Elemento

class SecondActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{

    private lateinit var binding: SecondActivityBinding
    lateinit var arraySpinner: ArrayList<String>
    lateinit var arrayElementos: ArrayList<Elemento>
    lateinit var adaptadorSencillo: ArrayAdapter<String>
    lateinit var adaptadorElementos: AdapterLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun asociarDatos() {
        binding.spinnerHobbies.adapter = adaptadorSencillo
        binding.listaElementos.adapter = adaptadorElementos
        binding.frameSeleccionado.isVisible = false
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        arrayElementos = ArrayList()
        adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rellenarSpinnerPersonalizado()
        adaptadorElementos = AdapterLista(arrayElementos,applicationContext)

    }

    private fun acciones() {
        binding.spinnerHobbies.onItemSelectedListener = this

        binding.listaElementos.setOnItemClickListener { adapterView, view, i, l ->
            var elemento: Elemento = adaptadorElementos.getItem(i) as Elemento
            binding.imagenElementoSeleccionado.setImageResource(elemento.imagen)
            binding.textoNombreSeleccionado.setText(elemento.nombre)
            binding.textoDescripcionSeleccionado.setText(elemento.descripcion)
            binding.frameSeleccionado.isVisible = true
        }
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add("Futbol")
        arraySpinner.add("Juegos")
        arraySpinner.add("Series")
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        if (p2 == 0){
            arrayElementos.clear()
            arrayElementos.add(Elemento("Messi", "FC. Barcelona", R.drawable.messi))
            arrayElementos.add(Elemento("Ronaldo", "Brasil", R.drawable.ronaldo))
            arrayElementos.add(Elemento("Maradona", "Argentina", R.drawable.maradona))
            arrayElementos.add(Elemento("Zidane", "Francia", R.drawable.zidane))
            adaptadorElementos.notifyDataSetChanged()
        }
        if (p2 == 1){
            arrayElementos.clear()
            arrayElementos.add(Elemento("Metal Gear", "Sigilo", R.drawable.metal))
            arrayElementos.add(Elemento("Gran Turismo", "Coches", R.drawable.gt))
            arrayElementos.add(Elemento("God Of War", "Plataformas", R.drawable.god))
            arrayElementos.add(Elemento("Final Fantasy X", "Rol", R.drawable.ffx))
            adaptadorElementos.notifyDataSetChanged()
        }
        if (p2 == 2){
            arrayElementos.clear()
            arrayElementos.add(Elemento("Stranger Things", "Fantastica", R.drawable.stranger))
            arrayElementos.add(Elemento("Juego de tronos", "Histórica", R.drawable.tronos))
            arrayElementos.add(Elemento("Lost", "Fantastica", R.drawable.lost))
            arrayElementos.add(Elemento("La casa de papel", "Accion", R.drawable.papel))
            adaptadorElementos.notifyDataSetChanged()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}