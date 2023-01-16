package com.example.t5_dialogos

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.t5_dialogos.databinding.ActivityMainBinding
import com.example.t5_dialogos.dialagos.*
import com.example.t5_dialogos.dialagos.model.Usuario

class MainActivity : AppCompatActivity(), View.OnClickListener,
    DialogoConfirmacion.OnDialogClickListener, DialogoLista.OnDialogSelection,
    DialogoListaSimple.OnDialogSelectionSimple, DialogoMultiple.OnDialogSelectionMult,
    DialogoPersonalizado.OnDialogLogin{

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

            }
            binding.botonConfirmacion.id -> {
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager,"")
            }
            binding.botonLista.id -> {
                val dialogoLista = DialogoLista()
                dialogoLista.show(supportFragmentManager,"")
            }
            binding.botonListasimpl.id -> {
                val dialogoListaSimple = DialogoListaSimple()
                dialogoListaSimple.show(supportFragmentManager,"")
            }
            binding.botonListamult.id -> {
                val dialogoListaMult = DialogoMultiple()
                dialogoListaMult.show(supportFragmentManager,"")
            }
            binding.botonPersonalizado.id -> {
                val dialogoPersonalizado = DialogoPersonalizado()
                dialogoPersonalizado.show(supportFragmentManager,"")
            }
        }
    }

    override fun onDialogClickListener(texto: String) {
        binding.textoConfirmacion.text = texto
    }

    override fun onDialogSelection(posicion: String) {
        binding.textoLista.text = posicion
    }

    override fun onDialogSelectionSimple(elemento: String?) {
        binding.textoListasimpl.text = elemento?:"Sin comunicacion"
    }

    override fun onDialogSelectionMult(lista: ArrayList<String>) {
        binding.textoListamult.text = lista.size.toString()
    }

    override fun onDialogLogin(usuario: Usuario) {
        binding.textoPersonalizado.text = usuario.toString()
        println(usuario)
    }
}