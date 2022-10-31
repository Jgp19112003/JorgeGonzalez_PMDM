package com.example.juegoupdown

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonEmpezar: Button
    lateinit var textoNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonEmpezar = findViewById(R.id.botonEmpezar)
        textoNombre = findViewById(R.id.textoNombre)
        botonEmpezar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.botonEmpezar -> {
                if (textoNombre.text.isEmpty()) {
                    Snackbar.make(p0!!, "Por favor introduce nombre", Snackbar.LENGTH_INDEFINITE).show()
                } else {
                    val texto = textoNombre.text.toString();
                    textoNombre.setText("")

                    // pasar de activity
                    // INTENT -> acciones

                    var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                    var datos: Bundle = Bundle()

                    datos.putString("nombre", texto)
                    intent.putExtras(datos)
                    startActivity(intent)
                }
            }
        }
    }
}
//JP