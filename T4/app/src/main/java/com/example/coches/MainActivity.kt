package com.example.coches

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coches.adapters.AdapterCoche
import com.example.coches.databinding.ActivityMainBinding
import com.example.coches.model.Coche
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var coches: ArrayList<Coche>
    private lateinit var lista_filtrada: ArrayList<Coche>
    lateinit var adaptadorMarca: ArrayAdapter<CharSequence>;
    lateinit var adaptadorPrecio: ArrayAdapter<CharSequence>;
    private lateinit var adapterCoche: AdapterCoche
    private  var cantidad_seleccionada: Int = 999999999
    private lateinit var marca_seleccionada: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones()


    }

    private fun acciones() {
        binding.spinnerMarca.adapter = adaptadorMarca;
        binding.spinnerPrecio.adapter = adaptadorPrecio;
    }

    @SuppressLint("ResourceType")
    private fun instancias() {
        coches = ArrayList()
        lista_filtrada = ArrayList()
        coches.add(Coche("Mercedes","AMG GT",500,200000,"Deportivo", R.drawable.amggt))
        coches.add(Coche("Bentley","Continental",400,300000,"Berlina deportivo", R.drawable.continental))
        coches.add(Coche("Jaguar","FType",300,150000,"Deportivo", R.drawable.ftype))
        coches.add(Coche("Ford","GT40",500,300000,"Deportivo clasico", R.drawable.gt40))
        coches.add(Coche("Nissan","GTR",300,200000,"Deportivo", R.drawable.gtr))
        coches.add(Coche("Porche","Huayara",600,400000,"Deportivo", R.drawable.huayra))
        coches.add(Coche("Lexus","LC",200,100000,"Deportivo", R.drawable.lc))
        coches.add(Coche("Ferrari","Le ferrari",600,500000,"Deportivo", R.drawable.leferrari))
        coches.add(Coche("McLaren","MC600",500,450000,"Deportivo", R.drawable.mc600))
        coches.add(Coche("Toyota","Supra",300,150000,"Deportivo", R.drawable.supra))
        coches.add(Coche("Porche","Taycan",350,250000,"Deportivo", R.drawable.taycan))

        adapterCoche = AdapterCoche(this, coches)
        adapterCoche.funcionComunicar = {Snackbar.make(binding.root, it.precio.toString(), Snackbar.LENGTH_SHORT).show()}
        binding.recycler.adapter = adapterCoche;
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.spinnerMarca.adapter = ArrayAdapter.createFromResource(applicationContext, R.array.marcas ,android.R.layout.simple_spinner_item)
        (binding.spinnerMarca.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrecio.adapter = ArrayAdapter.createFromResource(applicationContext, R.array.precios ,android.R.layout.simple_spinner_item)
        (binding.spinnerPrecio.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adaptadorMarca = ArrayAdapter.createFromResource(this,R.array.marcas, android.R.layout.simple_spinner_item);
        adaptadorPrecio = ArrayAdapter.createFromResource(this,R.array.precios, android.R.layout.simple_spinner_item);
        binding.spinnerMarca.onItemSelectedListener= this
        binding.spinnerPrecio.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when (p0?.id) {
            R.id.spinner_marca -> {
                 marca_seleccionada = adaptadorMarca.getItem(p2).toString()
                Log.v("marca", marca_seleccionada)
                if (marca_seleccionada == "Todos"){
                    adapterCoche.cambiarLista(coches)
                }else{
                    adapterCoche.cambiarLista(coches.filter {it.marca == marca_seleccionada && it.precio <= cantidad_seleccionada!!} as ArrayList)
                }
            }
            R.id.spinner_precio -> {
                 var precio_seleccionado = adaptadorPrecio.getItem(p2).toString()
                if (precio_seleccionado == "Todos"){
                    adapterCoche.cambiarLista(coches)
                }else {
                    cantidad_seleccionada = precio_seleccionado?.split(" ")?.get(1)?.toInt()
                    Log.v("precio", precio_seleccionado)
                    adapterCoche.cambiarLista(coches.filter {it.precio <= cantidad_seleccionada!! && it.marca.equals(marca_seleccionada)} as ArrayList)
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}