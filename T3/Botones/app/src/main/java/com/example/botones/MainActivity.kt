package com.example.botones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var grupoRadios: RadioGroup
    lateinit var radioUno: RadioButton
    lateinit var radioDos: RadioButton
    lateinit var radioTres: RadioButton
    lateinit var botonPulsar: Button
    lateinit var botonToggle: ToggleButton
    lateinit var checkEstado: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instancias()
        acciones()
    }

    fun instancias(){
        grupoRadios = this.findViewById(R.id.grupoRadios)
        radioUno = this.findViewById(R.id.grupoRadios)
        radioDos = this.findViewById(R.id.grupoRadios)
        radioTres = this.findViewById(R.id.grupoRadios)
        botonPulsar = this.findViewById(R.id.botonPulsar)
        botonToggle = this.findViewById(R.id.botonToggle)
        checkEstado = this.findViewById(R.id.checkEstado)
    }

    fun acciones(){
        botonPulsar.setOnClickListener(this)
        //botonToggle.setOnClickListener(this)
        grupoRadios.setOnCheckedChangeListener { radioGroup, i ->
            var radioSeleccionado: RadioButton = findViewById(grupoRadios.checkedRadioButtonId);
            Snackbar.make(radioSeleccionado,radioSeleccionado.text,Snackbar.LENGTH_SHORT).show()
        }

        botonToggle.setOnCheckedChangeListener { compoundButton, b ->
            Snackbar.make(botonToggle,b.toString(),Snackbar.LENGTH_SHORT).show()

        }
        checkEstado.setOnCheckedChangeListener { compoundButton, b ->
            Snackbar.make(checkEstado,b.toString(),Snackbar.LENGTH_SHORT).show()

        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.botonPulsar ->{
                botonToggle.isChecked = !botonToggle.isChecked
                checkEstado.isChecked = !checkEstado.isChecked
                var radioSeleccionado: RadioButton = findViewById(grupoRadios.checkedRadioButtonId);
                Snackbar.make(p0,radioSeleccionado.text,Snackbar.LENGTH_LONG).show()

                when(radioSeleccionado.id){
                    R.id.opc1 ->{}
                    R.id.opc2 ->{}
                    R.id.opc3 ->{}
                }
            }

            R.id.botonToggle ->{
                Snackbar.make(p0,botonToggle.isChecked.toString(),Snackbar.LENGTH_LONG).show()

            }
        }
    }
}