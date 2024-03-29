package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menus.adapter.AdaptadorAsignatura
import com.example.menus.databinding.ActivityMainBinding
import com.example.menus.dialogs.DialogoAdd
import com.example.menus.dialogs.DialogoDetails
import com.example.menus.dialogs.DialogoFiltrar
import com.example.menus.dialogs.DialogoIntroducirFiltro
import com.example.menus.model.Asignatura
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DialogoAdd.OnDialogAddAsignatura,
    AdaptadorAsignatura.OnRecyclerAsignaturaListener, DialogoDetails.OnDialogDetails,
    DialogoFiltrar.OnDialogFiltrar, DialogoIntroducirFiltro.OnDialogIntroducirFiltro{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorAsignatura
    private lateinit var seleccionado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        adaptador = AdaptadorAsignatura(ArrayList<Asignatura>(), this)

        binding.recyclerAsignaturas.adapter = adaptador;
        binding.recyclerAsignaturas.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL, false
        )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recycler, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.menu_add -> {
                // agregar algo al recycler --> adaptador
                DialogoAdd().show(supportFragmentManager, "")

            }
            R.id.menu_clear -> {
                adaptador.clearAsignaturas()
            }
            R.id.menu_filtrar -> {
                DialogoFiltrar().show(supportFragmentManager, "")
            }
        }
        return true
    }

    override fun OnDialogAddAsignatura(asignatura: Asignatura) {
        adaptador.addAsignatura(asignatura)
        Log.v("asignatura", asignatura.nombre)
    }

    override fun onAsignaturaSelected(asignatura: Asignatura) {
        DialogoDetails().show(supportFragmentManager, "")
        DialogoDetails.newInstance(
            asignatura.siglas,
            asignatura.nombre,
            asignatura.nombreProfesor,
            asignatura.horas,
            asignatura.ciclo,
            asignatura.curso
        ).show(supportFragmentManager, "")
    }

    override fun OnDialogDetails() {

    }

    override fun OnDialogFiltrar(seleccionado: String) {
        // TODO Hacer el filtro
        this.seleccionado = seleccionado
        DialogoIntroducirFiltro().show(supportFragmentManager,"")
    }

    override fun OnDialogIntroducirFiltro(filtroIntroducido: String) {

        when (seleccionado) {
            "Curso" -> {
                adaptador.cambiarLista(adaptador.listaAsignaturas.filter { it.curso == filtroIntroducido } as ArrayList<Asignatura>)
            }
            "Ciclo" -> {
                adaptador.cambiarLista(adaptador.listaAsignaturas.filter { it.ciclo == filtroIntroducido } as ArrayList<Asignatura>)
            }
            "Horas" -> {
                adaptador.cambiarLista(adaptador.listaAsignaturas.filter { it.horas == filtroIntroducido } as ArrayList<Asignatura>)
            }
        }
    }


}