package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menus.adapter.AdaptadorAsignaturas
import com.example.menus.databinding.ActivityMainBinding
import com.example.menus.dialogs.DialogoAdd
import com.example.menus.dialogs.DialogoDetails
import com.example.menus.model.Asignatura
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DialogoAdd.OnDialogAddAsignatura, AdaptadorAsignaturas.OnRecyclerAsignaturaListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorAsignaturas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        adaptador = AdaptadorAsignaturas(ArrayList<Asignatura>(),this)

        binding.recyclerAsignaturas.adapter = adaptador;
        binding.recyclerAsignaturas.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recycler, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {



        when (item.itemId) {
            R.id.menu_add -> {
                // agregar algo al recycler --> adaptador
                DialogoAdd().show(supportFragmentManager,"")

            }
            R.id.menu_clear -> {
                adaptador.clearAsignaturas()
            }
        }
        return true
    }

    override fun OnDialogAddAsignatura(asignatura: Asignatura) {
        adaptador.addAsignatura(asignatura)
    }

    override fun onAsignaturaSelected(asignatura: Asignatura) {
        DialogoDetails().show(supportFragmentManager,"")
        //TODO Se saca el dialogo de detalles, hay que hacer new instance para pasar la asignatura
        // para poder poner en el dialogo los datos de la asignatura (asignatura.siglas,asignatura.nombre...)
        // Hacer spinner personalizado de ciclo
    }


}