package com.example.menus.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.menus.R
import com.example.menus.model.Asignatura

class DialogoAdd : DialogFragment(){

    private lateinit var vista: View
    private lateinit var botonAdd: Button
    private lateinit var listener: OnDialogAddAsignatura
    private lateinit var editNombre: EditText
    private lateinit var editNombreProfesor: EditText
    private lateinit var editSiglas: EditText
    lateinit var arrayHoras: ArrayList<String>
    lateinit var spinnerHoras: Spinner
    lateinit var adaptadorHoras: ArrayAdapter<String>
    lateinit var arrayCurso: ArrayList<String>
    lateinit var spinnerCurso: Spinner
    lateinit var adaptadorCurso: ArrayAdapter<String>
    lateinit var arrayCiclo: ArrayList<String>
    lateinit var spinnerCiclo: Spinner
    lateinit var adaptadorCiclo: ArrayAdapter<String>


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogAddAsignatura
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_add,null)
        builder.setView(vista)

        return builder.create();
    }

    fun acciones(){
        botonAdd.setOnClickListener{
            var asignatura: Asignatura = (Asignatura(editSiglas.text.toString(),editNombre.text.toString(),
                editNombreProfesor.text.toString(),spinnerHoras.selectedItem.toString(),spinnerCiclo.selectedItem.toString(),spinnerCurso.selectedItem.toString()))
            listener.OnDialogAddAsignatura(asignatura)

            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }
    fun instancias(){
        botonAdd = vista.findViewById(R.id.boton_add)
        editSiglas = vista.findViewById(R.id.texto_siglas)
        editNombre = vista.findViewById(R.id.texto_nombre)
        editNombreProfesor = vista.findViewById(R.id.texto_nombreProfesor)
        spinnerHoras = vista.findViewById(R.id.horas_spinner)
        spinnerCurso = vista.findViewById(R.id.curso_spinner)

        arrayHoras = ArrayList()
        arrayHoras.add("3")
        arrayHoras.add("4")
        arrayHoras.add("5")
        arrayHoras.add("6")
        arrayHoras.add("7")
        arrayHoras.add("8")
        adaptadorHoras = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,arrayHoras)
        spinnerHoras.adapter = adaptadorHoras

        arrayCurso = ArrayList()
        arrayCurso.add("1")
        arrayCurso.add("2")
        adaptadorCurso = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,arrayCurso)
        spinnerCurso.adapter = adaptadorCurso

        arrayCiclo = ArrayList()
        arrayCiclo.add("DAM")
        arrayCiclo.add("DAW")
        arrayCiclo.add("ASIR")
        adaptadorCiclo = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,arrayCiclo)
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }

    interface OnDialogAddAsignatura{
        fun OnDialogAddAsignatura(asignatura: Asignatura)
    }
}