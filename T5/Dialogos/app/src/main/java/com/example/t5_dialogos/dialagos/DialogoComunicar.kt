package com.example.t5_dialogos.dialagos

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos.R

class DialogoComunicar : DialogFragment() {

    private lateinit var nombre: String
    private lateinit var mensaje: String

    companion object {
        // todo lo declarado aqui es accesible directamente
        // 1. TODO creo un método newInstance como parametro lo que va a recibir el dialogo
        //      devuelve el objeto del tipo que quiere construir

        fun newInstance(nombre: String): DialogoComunicar {

            val dialogo = DialogoComunicar()
            // 2. TODO creo los argumentos con los datos que van en los parámetros
            // y se lo pongo al cuadro
            val bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putString("mensaje", "Esto es un ejemplo de mensaje pasado")
            dialogo.arguments = bundle
            return dialogo
        }
    }

    // cuadro de diálogo

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 3. TODO recupero todos los argumentos que quiera utilizar
        this.nombre = this.arguments?.getString("nombre", "sobre el tag") ?: "Sin nombrw"
        this.mensaje = this.arguments?.getString("mensaje", "sobre el tag") ?: "Sin nombrw"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(nombre)
        builder.setMessage(mensaje)
        return builder.create()
    }
}