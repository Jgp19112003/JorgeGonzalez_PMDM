package com.example.t5_dialogos.dialagos

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos.R

class DialogoComunicar : DialogFragment(){
    lateinit var nombre: String
    lateinit var mensaje: String
    companion object{
        // todo lo declarado aqui es accesible directamente
        // 1. TODO creo un metodo newInstance como parametro lo que va a recibir el dialogo
        //      devuelve el objeto del tipo que quiere construir

        fun newInstance(nombre: String): DialogoComunicar{

            val dialogo = DialogoComunicar()
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putString("mensaje","Esto es un ejemplo de mensaje pasado")
            dialogo.arguments = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.nombre = this.arguments?.getString("nombre","sobre el tag") ?: "Sin nombre"
        this.mensaje = this.arguments?.getString("mensaje","sobre el tag") ?: "Sin mensaje"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        return builder.create();
    }
}