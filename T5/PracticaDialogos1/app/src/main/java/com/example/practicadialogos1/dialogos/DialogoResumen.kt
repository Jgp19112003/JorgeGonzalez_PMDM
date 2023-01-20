package com.example.practicadialogos1.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos1.R

class DialogoResumen : DialogFragment() {

    private lateinit var vista: View
    private lateinit var textoNombre: TextView
    private lateinit var textoHora: TextView
    private lateinit var textoFecha: TextView
    private lateinit var textoAsignturas: TextView
    private lateinit var textoMedia: TextView


    companion object{

        fun newInstance(nombre: String,hora: String,fecha: String,asignaturas: String,media: String): DialogoResumen {
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("hora", hora)
            args.putString("fecha", fecha)
            args.putString("asignaturas", asignaturas)
            args.putString("media", media)
            val fragment = DialogoResumen()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var listener: OnDialogResumen
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogResumen
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_resumen, null)
        builder.setView(vista)

        return builder.create();
    }

    override fun onResume() {
        super.onResume()
    }

    fun instancias() {
        textoNombre = vista.findViewById(R.id.texto_nombre)
        textoHora = vista.findViewById(R.id.texto_hora)
        textoFecha = vista.findViewById(R.id.texto_fecha)
        textoAsignturas = vista.findViewById(R.id.texto_asignaturas)
        textoMedia = vista.findViewById(R.id.texto_media)
    }

    override fun onStart() {
        instancias()
        acciones()
        super.onStart()
    }

    private fun acciones() {
        textoNombre.text = this.arguments?.get("nombre").toString()
        textoHora.text = this.arguments?.get("hora").toString()
        textoFecha.text = this.arguments?.get("fecha").toString()
        textoAsignturas.text = this.arguments?.get("asignaturas").toString()
        textoMedia.text = this.arguments?.get("media").toString()
    }

    interface OnDialogResumen {
        fun onDialogResumen()
    }
}
