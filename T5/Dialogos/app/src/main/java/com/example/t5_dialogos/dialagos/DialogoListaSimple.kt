package com.example.t5_dialogos.dialagos

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoListaSimple : DialogFragment() {

    private lateinit var listener: DialogoLista.OnDialogSelection
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as DialogoLista.OnDialogSelection
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        builder.setTitle("Titulo de lista")

        //builder.setMessage("Mensaje de la lista")
        builder.setSingleChoiceItems(elementos,0,DialogInterface.OnClickListener { dialogInterface, i -> listener.onDialogSelection(elementos.get(i).toString())
            // i --> posicion pulsada
        })
        builder.setPositiveButton("Aceptar",{ dialogInterface, i -> })

        builder.setNegativeButton("Cancelar",{ dialogInterface, i -> })


        return builder.create();
    }

}