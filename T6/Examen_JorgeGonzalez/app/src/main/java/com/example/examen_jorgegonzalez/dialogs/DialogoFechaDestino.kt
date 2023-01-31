package com.example.examen_jorgegonzalez.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoFechaDestino: DialogFragment() {

    private lateinit var listener: DialogoFechaOrigen.OnDialogoFecha
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as DialogoFechaOrigen.OnDialogoFecha
    }

    companion object{
        fun newInstance(anio: Int, mes: Int, dia: Int): DialogoFechaDestino {


            val args = Bundle()
            args.putInt("anio", anio)
            args.putInt("mes", mes)
            args.putInt("dia", dia)
            val fragment = DialogoFechaDestino()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var anio = this.arguments?.get("anio") as Int
        var mes = this.arguments?.get("mes") as Int
        var dia = this.arguments?.get("dia") as Int
        val dialogoHora = DatePickerDialog(requireContext(),activity as DatePickerDialog.OnDateSetListener,anio,mes,dia)
        listener.OnDialogoFecha()
        return dialogoHora
    }

}