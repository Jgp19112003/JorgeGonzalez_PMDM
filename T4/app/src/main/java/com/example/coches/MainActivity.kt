package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coches.adapters.AdapterCoche
import com.example.coches.databinding.ActivityMainBinding
import com.example.coches.model.Coche


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var coches: ArrayList<Coche>
    lateinit var adaptadorMarca: ArrayAdapter<String>;
    lateinit var adaptadorPrecio: ArrayAdapter<Int>;
    private lateinit var adapterCoche: AdapterCoche

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

    private fun instancias() {
        coches = ArrayList()

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
        binding.recycler.adapter = adapterCoche;
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.spinnerMarca.adapter = ArrayAdapter.createFromResource(applicationContext, R.array.marcas ,android.R.layout.simple_spinner_item)
        (binding.spinnerMarca.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrecio.adapter = ArrayAdapter.createFromResource(applicationContext, R.array.precios ,android.R.layout.simple_spinner_item)
        (binding.spinnerPrecio.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }
}