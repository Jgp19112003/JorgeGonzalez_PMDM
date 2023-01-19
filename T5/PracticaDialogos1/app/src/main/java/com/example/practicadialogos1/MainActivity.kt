package com.example.practicadialogos1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.practicadialogos1.databinding.ActivityMainBinding
import com.example.practicadialogos1.dialogos.*
import com.example.practicadialogos1.model.Usuario

class MainActivity : AppCompatActivity(),
    TimePickerDialog.OnTimeSetListener,  DatePickerDialog.OnDateSetListener,
    DialogoDatosUsuario.OnDialogLogin, DialogoConfirmacion.OnDialogClickConfirmacion,
    DialogoAsignaturas.OnDialogSelectionMult, DialogoNotaMedia.OnDialogNota{

    private lateinit var binding: ActivityMainBinding
    private var hora = 0
    private var min = 0
    private var anio = 0
    private var mes = 0
    private var dia = 0
    private lateinit var notaMedia: String
    private lateinit var usuario: Usuario
    private lateinit var mensaje: String
    private lateinit var asignaturas: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonEmpezar.setOnClickListener(){
            DialogoHora().show(supportFragmentManager,"")
        }
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        hora = p1
        min = p2
        DialogoFecha().show(supportFragmentManager,"")
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        anio = p1
        mes = p2
        dia = p3
        DialogoDatosUsuario().show(supportFragmentManager,"")
    }

    override fun onDialogLogin(usuario: Usuario) {
        this.usuario = usuario
        //TODO new instance del confirmacion con el texto
        mensaje = "Buenos dias "+usuario.nombre+", vas a registrar una respuesta el "+dia+"/"+(mes+1)+" a las "+hora+":"+min
        val dialogoConfirmacion = DialogoConfirmacion.newInstance(mensaje)
        dialogoConfirmacion.show(supportFragmentManager,"")
    }

    override fun onDialogClickConfirmacion(boolean: Boolean) {
        if (boolean) {
            println(mensaje)
            DialogoAsignaturas().show(supportFragmentManager,"")
        }
    }

    override fun onDialogSelectionMult(lista: ArrayList<String>) {
        asignaturas = lista
        asignaturas.forEach { item ->
            println(item)
        }
        DialogoNotaMedia().show(supportFragmentManager,"")
    }

    override fun onDialogNota(nota: String) {
        notaMedia = nota
    }
}