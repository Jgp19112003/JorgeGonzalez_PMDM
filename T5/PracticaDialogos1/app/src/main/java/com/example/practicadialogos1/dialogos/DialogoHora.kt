package com.example.practicadialogos1.dialogos

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DialogoHora : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val caledario = Calendar.getInstance();
        val hora = caledario.get(Calendar.HOUR_OF_DAY)
        val minutos = caledario.get(Calendar.MINUTE)
        val dialogo = TimePickerDialog(requireContext(), requireContext() as TimePickerDialog.OnTimeSetListener,hora,minutos,false)
        return dialogo
    }
}