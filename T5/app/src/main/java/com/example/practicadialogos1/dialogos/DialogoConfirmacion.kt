package com.example.practicadialogos1.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos1.R

class DialogoConfirmacion : DialogFragment() {
    private lateinit var listener: OnDialogClickListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogClickListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())


        builder.setMessage("¿Estás seguro que quieres coninuar el progreso?")

        builder.setPositiveButton("OK",{ dialogInterface, i -> listener.onDialogClickListener("Pulsado positivo") })

        builder.setNegativeButton("CANCELAR",{ dialogInterface, i -> listener.onDialogClickListener("Pulsado negativo")})

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogClickListener{
        fun onDialogClickListener(texto: String)
    }

}