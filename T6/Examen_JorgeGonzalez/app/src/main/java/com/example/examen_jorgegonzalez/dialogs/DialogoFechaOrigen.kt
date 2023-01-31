package com.example.examen_jorgegonzalez.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoFechaOrigen : DialogFragment() {
    private lateinit var listener: OnDialogoFecha
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoFecha
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogoHora = DatePickerDialog(requireContext(),activity as DatePickerDialog.OnDateSetListener,2023,0,31)
        listener.OnDialogoFecha()
        return dialogoHora
    }

    interface OnDialogoFecha{
        fun OnDialogoFecha()
    }
}