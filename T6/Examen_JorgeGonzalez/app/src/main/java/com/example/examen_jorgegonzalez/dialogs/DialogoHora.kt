package com.example.examen_jorgegonzalez.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogo = TimePickerDialog(context, activity as TimePickerDialog.OnTimeSetListener, 0,0,false)
        return dialogo
    }
}