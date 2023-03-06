package com.example.ejerciciorepaso.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.ejerciciorepaso.R
import com.example.ejerciciorepaso.model.Coche

class DialogoDetalle : DialogFragment() {

    private lateinit var vista: View
    private lateinit var modelo: String
    private lateinit var cv: String
    private lateinit var color: String

    private lateinit var modelo_text: TextView
    private lateinit var cv_text: TextView
    private lateinit var color_text: TextView
    private lateinit var listener: OnDialogCoche

    companion object {
        // todo lo declarado aqui es accesible directamente
        // 1. TODO creo un método newInstance como parametro lo que va a recibir el dialogo
        //      devuelve el objeto del tipo que quiere construir

        fun newInstance(
            modelo: String?=null,
            cv: String?=null,
            color: String?=null
        ): DialogoDetalle {

            val dialogo = DialogoDetalle()
            // 2. TODO creo los argumentos con los datos que van en los parámetros
            // y se lo pongo al cuadro
            val bundle = Bundle()
            bundle.putString("modelo", modelo)
            bundle.putString("cv", cv)
            bundle.putString("color", color)
            dialogo.arguments = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogCoche
        this.modelo = (this.arguments?.getString("modelo") ?: "Sin modelo")
        this.cv = this.arguments?.getString("cv") ?: "Sin cv"
        this.color = this.arguments?.getString("color") ?: "Sin color"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_dialogo,null)
        builder.setView(vista)

        return builder.create();
    }

    override fun onResume() {
        super.onResume()
    }
    fun instancias(){
        modelo_text = vista.findViewById(R.id.texto_modelo)
        cv_text = vista.findViewById(R.id.texto_cv)
        color_text = vista.findViewById(R.id.texto_color)

        modelo_text.text = "Modelo: $modelo"
        cv_text.text = "CV: $cv"
        color_text.text= "Color: $color"
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }

    interface OnDialogCoche{
        fun onDialogCoche(coche: Coche)
    }
}