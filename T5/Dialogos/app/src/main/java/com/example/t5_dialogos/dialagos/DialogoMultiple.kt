package com.example.t5_dialogos.dialagos

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoMultiple : DialogFragment(){

    private lateinit var listener: OnDialogSelectionMult
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogSelectionMult
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        val elementosSeleccionados = ArrayList<String>()
        builder.setTitle("Titulo de lista")

        builder.setMultiChoiceItems(elementos, null){ _,posicion, boolean ->
            Log.v("dialogos", "${posicion.toString()}, ${boolean.toString()}")

            if (boolean){
                elementosSeleccionados.add(elementos[posicion])
            } else {
                elementosSeleccionados.remove(elementos[posicion])
            }
        }

        builder.setPositiveButton("OK",{ _, _ ->
            Log.v("dialogos", "realizar comunicacion")

            listener.onDialogSelectionMult(elementosSeleccionados)

        })

        builder.setNeutralButton("Cerrar",{ _, _ ->
            Log.v("dialogos", "cerrando boton")
        })

        return builder.create();
    }

    interface OnDialogSelectionMult{
        fun onDialogSelectionMult(lista: ArrayList<String>)
    }
}