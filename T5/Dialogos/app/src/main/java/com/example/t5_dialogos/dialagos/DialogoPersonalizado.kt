package com.example.t5_dialogos.dialagos

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos.R

class DialogoPersonalizado : DialogFragment(){

    private lateinit var vista: View
    private lateinit var botonLogin: Button
    private lateinit var editNombre: EditText
    private lateinit var editPass: EditText
    private lateinit var checkRecordar: CheckBox
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_dialogopers,null)
        builder.setView(vista)

        return builder.create();
    }

    fun acciones(){
        botonLogin.setOnClickListener{
            Log.v("dialogo","Boton dialogo pulsado")
        }
        // TODO Comunicar usuario(nombre, pass, recordarContraseña)
    }

    override fun onResume() {
        super.onResume()
    }
    fun instancias(){
        botonLogin = vista.findViewById(R.id.botonLogin)
        editNombre = vista.findViewById(R.id.editText1)
        editPass = vista.findViewById(R.id.editText2)
        checkRecordar = vista.findViewById(R.id.checkBox)
    }

    override fun onStart() {
        instancias()
        acciones()
        super.onStart()
    }
}