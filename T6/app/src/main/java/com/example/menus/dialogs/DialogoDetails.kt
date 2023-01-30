package com.example.menus.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.menus.R
import com.example.menus.model.Asignatura

class DialogoDetails : DialogFragment(){

    private lateinit var vista: View
    private lateinit var listener: OnDialogDetails
    private lateinit var editNombre: TextView
    private lateinit var editSiglas: TextView
    private lateinit var editHoras: TextView
    private lateinit var editNombreProfesor: TextView
    private lateinit var editCurso: TextView
    private lateinit var editCiclo: TextView

    //private lateinit var asignatura: Asignatura

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //asignatura = this.arguments?.getSerializable("asignatura") as Asignatura

    }
    companion object{
        fun newInstance(siglas: String, nombre: String, nombreProfesor: String, horas: String, ciclo: String, curso: String): DialogoDetails {
            val args = Bundle()
            args.putString("siglas",siglas)
            args.putString("nombre",nombre)
            args.putString("nombreProfesor",nombreProfesor)
            args.putString("horas",horas)
            args.putString("ciclo",ciclo)
            args.putString("curso",curso)
            val fragment = DialogoDetails()
            fragment.arguments = args
            return fragment
        }
    }
    /*companion object{
        fun newInstance(asignatura: Asignatura): DialogoDetails {
            val args = Bundle()
            Log.v("asignatura",asignatura.nombre)
            args.putSerializable("asignatura",asignatura)
            args.putString("nombre","Jorge")
            val fragment = DialogoDetails()
            fragment.arguments = args
            return fragment
        }
    }*/

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_details,null)
        builder.setView(vista)
        return builder.create();
    }
    override fun onStart() {
        instancias()
        acciones()
        super.onStart()
    }

    private fun acciones() {
        editSiglas.text = this.arguments?.getString("siglas").toString()
        editNombre.text = this.arguments?.getString("nombre").toString()
        editNombreProfesor.text = this.arguments?.getString("nombreProfesor").toString()
        editHoras.text = this.arguments?.getString("horas").toString()
        editCiclo.text = this.arguments?.getString("ciclo").toString()
        editCurso.text = this.arguments?.getString("curso").toString()
    }

    private fun instancias() {
        editSiglas = vista.findViewById(R.id.edit_siglas)
        editNombre = vista.findViewById(R.id.edit_nombre)
        editCiclo = vista.findViewById(R.id.edit_ciclo)
        editCurso = vista.findViewById(R.id.edit_curso)
        editHoras = vista.findViewById(R.id.edit_horas)
        editNombreProfesor = vista.findViewById(R.id.edit_nombreProfesor)
        Log.v("instancias","instanciado")
    }

    interface OnDialogDetails{
        fun OnDialogDetails()
    }


}