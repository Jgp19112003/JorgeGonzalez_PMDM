package com.example.examen_jorgegonzalez

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen_jorgegonzalez.adapters.AdaptadorDestino
import com.example.examen_jorgegonzalez.adapters.AdaptadorOrigen
import com.example.examen_jorgegonzalez.adapters.AdaptadorRecycler
import com.example.examen_jorgegonzalez.databinding.ActivityMainBinding
import com.example.examen_jorgegonzalez.dialogs.DialogoFechaDestino
import com.example.examen_jorgegonzalez.dialogs.DialogoFechaOrigen
import com.example.examen_jorgegonzalez.dialogs.DialogoHora
import com.example.examen_jorgegonzalez.models.Ciudad
import com.example.examen_jorgegonzalez.models.Viaje
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),
    DatePickerDialog.OnDateSetListener, DialogoFechaOrigen.OnDialogoFecha,
    TimePickerDialog.OnTimeSetListener, DialogoFechaDestino.OnDialogoFechaD{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var arrayCiudades: ArrayList<Ciudad>
    private lateinit var adaptadorOrigen: AdaptadorOrigen
    private lateinit var adaptadorDestino: AdaptadorDestino
    private var anio: Int = 0
    private var mes: Int = 0
    private var dia: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        adaptadorRecycler = AdaptadorRecycler(this,ArrayList<Viaje>())
        binding.recyclerViajes.adapter = adaptadorRecycler;
        binding.recyclerViajes.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL, false
        )
        instancias()
        acciones()
    }

    private fun instancias() {
        arrayCiudades = ArrayList()
        arrayCiudades.add(Ciudad(R.drawable.barcelona,"Barcelona"))
        arrayCiudades.add(Ciudad(R.drawable.madrid,"Madrid"))
        arrayCiudades.add(Ciudad(R.drawable.londres,"Barcelona"))
        arrayCiudades.add(Ciudad(R.drawable.miami,"Miami"))
        arrayCiudades.add(Ciudad(R.drawable.newyork,"NewYork"))
        arrayCiudades.add(Ciudad(R.drawable.sanfrancisco,"SanFrancisco"))

        adaptadorOrigen = AdaptadorOrigen(arrayCiudades,this)
        binding.spinnerOrigen.adapter = adaptadorOrigen

        adaptadorDestino = AdaptadorDestino(arrayCiudades,this)
        binding.spinnerDestino.adapter = adaptadorDestino
    }

    private fun acciones() {
        binding.textoFechaO.setOnClickListener{
            DialogoFechaOrigen().show(supportFragmentManager,"")
            binding.textoFechaO.text = "${dia}/${mes+1}/${anio}"
            DialogoHora().show(supportFragmentManager,"")

        }
        binding.textoFechaD.setOnClickListener{
            DialogoFechaDestino.newInstance(anio,mes,dia).show(supportFragmentManager,"")
            binding.textoFechaD.text = "${dia}/${mes+1}/${anio}"
            DialogoHora().show(supportFragmentManager,"")
        }

        binding.botonAdd.setOnClickListener {
            adaptadorRecycler.addViaje(Viaje(binding.spinnerDestino.selectedItem as Ciudad,binding.textoFechaO.text.toString(),binding.textoFechaD.text.toString()))
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_viajes,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_info->{

            }
            R.id.menu_cerrar->{

            }
        }

        return true
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        anio = year
        mes = month
        dia = dayOfMonth

        binding.textoFechaD.text = "${dia}/${mes+1}/${anio}"

    }

    override fun OnDialogoFecha() {


    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

    }

    override fun OnDialogoFechaD() {

    }
}