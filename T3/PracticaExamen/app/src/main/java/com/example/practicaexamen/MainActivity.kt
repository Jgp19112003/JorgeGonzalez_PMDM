package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.practicaexamen.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()


    }

    private fun acciones() {
        binding.botonIniciar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.botonIniciar -> {
                if (!binding.editTextNombre.text.isEmpty() && !binding.editTextApellido.text.isEmpty()) {
                    Snackbar.make(
                        binding.botonIniciar,
                        "Por favor introduce nombre y apellido",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    val textoNombre = binding.editTextNombre.text.toString();
                    val textoApellido = binding.editTextApellido.text.toString();
                    binding.editTextNombre.setText("")

                    // pasar de activity
                    // INTENT -> acciones

                    var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                    var datos: Bundle = Bundle()

                    datos.putString("nombre", textoNombre)
                    datos.putString("apellido", textoApellido)
                    intent.putExtras(datos)
                    startActivity(intent)
                }else {
                    Toast.makeText(applicationContext,"Ingrese nombre y apellido",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}