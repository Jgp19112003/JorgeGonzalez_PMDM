package com.example.practicadialogos1.dialogos

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos1.R
import com.example.practicadialogos1.model.Usuario

class DialogoNotaMedia : DialogFragment() {

    private lateinit var vista: View
    private lateinit var editNota: EditText
    private lateinit var botonSiguiente: Button
    private lateinit var listener: OnDialogNota

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogNota
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_notamedia, null)
        builder.setView(vista)

        return builder.create();
    }

    fun acciones() {
        botonSiguiente.setOnClickListener {
            var nota: String = editNota.text.toString()
            listener.onDialogNota(nota)

            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    fun instancias() {
        botonSiguiente = vista.findViewById(R.id.botonSiguiente)
        editNota = vista.findViewById(R.id.editTextNota)
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }

    interface OnDialogNota {
        fun onDialogNota(nota: String)
    }
}

