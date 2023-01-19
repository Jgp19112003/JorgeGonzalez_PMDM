package com.example.practicadialogos1.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment

class DialogoAsignaturas : DialogFragment(){

    private lateinit var listener: OnDialogSelectionMult
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogSelectionMult
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val asignaturas = arrayOf("PMDM", "DI", "AD","SGE","EIE","ING")
        val asignaturasSeleccionados = ArrayList<String>()

        builder.setTitle("¿De cuantas asignaturas te has evaluado?")

        builder.setMultiChoiceItems(asignaturas,null){ _, posicion, boolean ->
            Log.v("dialogos", "${posicion.toString()} ${boolean.toString()}")

            if (boolean){
                asignaturasSeleccionados.add(asignaturas[posicion])
            } else {
                asignaturasSeleccionados.remove(asignaturas[posicion])
            }
        }

        builder.setPositiveButton("OK",{ _, _ ->
            listener.onDialogSelectionMult(asignaturasSeleccionados)
        })

        builder.setNeutralButton("Cerrar",{ _, _ ->
            dismiss()
        })

        return builder.create()
    }

    interface OnDialogSelectionMult{
        fun onDialogSelectionMult(lista: ArrayList<String>)
    }
}