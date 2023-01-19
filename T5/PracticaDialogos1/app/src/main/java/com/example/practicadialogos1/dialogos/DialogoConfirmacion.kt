package com.example.practicadialogos1.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.practicadialogos1.R
import com.example.practicadialogos1.model.Usuario

class DialogoConfirmacion : DialogFragment() {
    companion object{

        fun newInstance(mensaje: String): DialogoConfirmacion {
            val args = Bundle()
            args.putString("mensaje", mensaje)
            val fragment = DialogoConfirmacion()
            fragment.arguments = args
            return fragment
        }
    }
    private lateinit var listener: OnDialogClickConfirmacion
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogClickConfirmacion
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireActivity())
        var mensaje = this.arguments?.get("mensaje")

        builder.setMessage(mensaje.toString())

        builder.setPositiveButton("OK",{ dialogInterface, i -> listener.onDialogClickConfirmacion(true) })
        builder.setNegativeButton("CANCELAR",{dialogInterface, i -> listener.onDialogClickConfirmacion(false) })
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogClickConfirmacion{
        fun onDialogClickConfirmacion(boolean: Boolean)
    }

}