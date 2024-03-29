package com.example.practicadialogos2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicadialogos2.adapters.AdaptadorRecycler

import com.example.practicadialogos2.R
import com.example.practicadialogos2.databinding.ActivityMainBinding
import com.example.practicadialogos2.dialogs.DialogoDetalle
import com.example.practicadialogos2.model.Usuario

class MainActivity : AppCompatActivity(), AdaptadorRecycler.OnDialogRecycler {

    lateinit var binding: ActivityMainBinding
    lateinit var adaptadorRecycler: AdaptadorRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones()
    }


    private fun instancias() {
        adaptadorRecycler = AdaptadorRecycler(this, ArrayList())
        binding.recyclerTrabajador.adapter = adaptadorRecycler
        binding.recyclerTrabajador.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)


        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.puestos_array,
            android.R.layout.simple_spinner_dropdown_item
        )
        binding.spinnerPuesto.adapter = adapter
    }

    private fun acciones() {
        binding.botonAdd.setOnClickListener {
            adaptadorRecycler.addUsuario(
                Usuario(
                    binding.nombreEdit.text.toString(),
                    binding.apellidosEdit.text.toString(),
                    binding.correoEdit.text.toString(),
                    binding.edadEdit.text.toString(),
                    binding.spinnerPuesto.selectedItem.toString()
                )
            )
        }
    }

    override fun OnDialogRecycler(usuario: Usuario) {
        DialogoDetalle.newInstance(
            usuario.nombre,
            usuario.apellido,
            usuario.correo,
            usuario.edad,
            usuario.puesto
        ).show(supportFragmentManager,"")
    }
}