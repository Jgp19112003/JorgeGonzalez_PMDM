package com.example.t5_dialogos

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.t5_dialogos.databinding.ActivityMainBinding
import com.example.t5_dialogos.dialagos.DialogoConfirmacion

class MainActivity : AppCompatActivity(), View.OnClickListener, DialogoConfirmacion.OnDialogClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonLista.setOnClickListener(this)
        binding.botonListamult.setOnClickListener(this)
        binding.botonListasimpl.setOnClickListener(this)
        binding.botonPersonalizado.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConfirmacion.id -> {
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager,"")


            }
            binding.botonLista.id -> {

            }
            binding.botonListamult.id -> {

            }
            binding.botonListasimpl.id -> {

            }
            binding.botonPersonalizado.id -> {

            }
        }
    }

    override fun onDialogClickListener(texto: String) {
        binding.textoConfirmacion.text = texto
    }
}