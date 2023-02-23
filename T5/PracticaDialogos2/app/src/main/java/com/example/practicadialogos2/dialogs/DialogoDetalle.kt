package com.example.practicadialogos2.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos2.R

class DialogoDetalle : DialogFragment() {

    private lateinit var vista: View

    private lateinit var nombre_label: TextView
    private lateinit var apellido_label: TextView
    private lateinit var correo_label: TextView
    private lateinit var edad_label: TextView
    private lateinit var puesto_label: TextView

    companion object {
        // todo lo declarado aqui es accesible directamente
        // 1. TODO creo un método newInstance como parametro lo que va a recibir el dialogo
        //      devuelve el objeto del tipo que quiere construir

        fun newInstance(
            nombre: String,
            apellido: String,
            correo: String,
            edad: String,
            puesto: String
        ): DialogoDetalle {

            val dialogo = DialogoDetalle()
            // 2. TODO creo los argumentos con los datos que van en los parámetros
            // y se lo pongo al cuadro
            val bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putString("apellido", apellido)
            bundle.putString("correo", correo)
            bundle.putString("edad", edad)
            bundle.putString("puesto", puesto)
            dialogo.arguments = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 3. TODO recupero todos los argumentos que quiera utilizar
        this.nombre_label.text = this.arguments?.getString("nombre") ?: "Sin nombre"
        this.apellido_label.text = this.arguments?.getString("apellido") ?: "Sin apellido"
        this.correo_label.text = this.arguments?.getString("correo") ?: "Sin correo"
        this.edad_label.text = this.arguments?.getString("edad") ?: "Sin edad"
        this.puesto_label.text   = this.arguments?.getString("puesto") ?: "Sin puesto"
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_detalle, null)
        builder.setView(vista)

        return builder.create()
    }

    private fun instancias() {
        nombre_label = vista.findViewById(R.id.detalle_nombre)
        apellido_label = vista.findViewById(R.id.detalle_apellido)
        correo_label = vista.findViewById(R.id.detalle_correo)
        edad_label = vista.findViewById(R.id.detalle_edad)
        puesto_label = vista.findViewById(R.id.detalle_puesto)
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }
}
