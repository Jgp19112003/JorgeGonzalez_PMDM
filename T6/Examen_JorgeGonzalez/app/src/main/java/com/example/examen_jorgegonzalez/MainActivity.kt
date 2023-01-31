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

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, DialogoFechaOrigen.OnDialogoFecha, TimePickerDialog.OnTimeSetListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var arrayCiudades: ArrayList<Ciudad>
    private lateinit var adaptadorOrigen: AdaptadorOrigen
    private lateinit var adaptadorDestino: AdaptadorDestino
    val anio = Calendar.getInstance().get(Calendar.YEAR)
    val mes = Calendar.getInstance().get(Calendar.MONTH)
    val day = Calendar.getInstance().get(Calendar.DATE)

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
        binding.spinnerOrigen.adapter = adaptadorDestino
    }

    private fun acciones() {
        binding.textoFechaO.setOnClickListener{
            DialogoFechaOrigen().show(supportFragmentManager,"")

        }
        binding.textoFechaD.setOnClickListener{
            DialogoFechaDestino().show(supportFragmentManager,"")
        }

        binding.botonAdd.setOnClickListener {
            //adaptadorRecycler.addViaje(Viaje())
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

    }

    override fun OnDialogoFecha() {
        DialogoHora().show(supportFragmentManager,"")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

    }
}