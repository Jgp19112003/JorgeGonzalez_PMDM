package com.example.menus.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.menus.R

class DialogoIntroducirFiltro : DialogFragment(){

    private lateinit var listener: OnDialogIntroducirFiltro
    private lateinit var vista: View
    private lateinit var editFiltro: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogIntroducirFiltro
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_introducirfiltro,null)
        builder.setView(vista)
        builder.setPositiveButton("Aceptar") { dialogo, posicion->
            listener.OnDialogIntroducirFiltro(editFiltro.text.toString())
        }
        return builder.create();
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }

    private fun instancias() {
        editFiltro = vista.findViewById(R.id.edit_filtrar)
    }

    interface OnDialogIntroducirFiltro{
        fun OnDialogIntroducirFiltro(filtroIntroducido: String)
    }
}