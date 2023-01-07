package com.example.t5_dialogos.dialagos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos.R
import com.google.android.material.snackbar.Snackbar

class DialogoConfirmacion : DialogFragment() {
    private lateinit var listener: OnDialogClickListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogClickListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle(resources.getString(R.string.titulo_dialogo))

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