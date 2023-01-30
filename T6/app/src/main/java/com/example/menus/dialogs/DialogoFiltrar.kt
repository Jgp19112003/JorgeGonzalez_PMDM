package com.example.menus.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.menus.R
import com.example.menus.model.Asignatura

class DialogoFiltrar : DialogFragment() {

    private lateinit var listener: OnDialogFiltrar
    private lateinit var vista: View
    lateinit var arrayFiltrar: ArrayList<String>
    lateinit var spinnerFiltrar: Spinner
    lateinit var adaptadorFiltrar: ArrayAdapter<String>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogFiltrar
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_filtrar,null)
        builder.setView(vista)
        builder.setPositiveButton("Aceptar") { dialogo, posicion->
            listener.OnDialogFiltrar(spinnerFiltrar.selectedItem.toString())
        }
        return builder.create();
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }

    private fun instancias() {
        spinnerFiltrar= vista.findViewById(R.id.spinner_filtrar)
        arrayFiltrar = ArrayList()
        arrayFiltrar.add("Curso")
        arrayFiltrar.add("Ciclo")
        arrayFiltrar.add("Horas")
        adaptadorFiltrar = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,arrayFiltrar)
        spinnerFiltrar.adapter = adaptadorFiltrar
    }

    interface OnDialogFiltrar{
        fun OnDialogFiltrar(seleccionado: String)
    }
}