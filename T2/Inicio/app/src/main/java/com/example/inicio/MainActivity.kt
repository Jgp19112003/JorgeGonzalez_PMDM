package com.example.inicio


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var botonPasar: Button
    lateinit var textoSaludo: TextView
    lateinit var texto_introducido: EditText
    lateinit var texto_cambiado: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonPulsar = findViewById(R.id.boton_pulsar)
        botonPasar = findViewById(R.id.boton_pasar)
        texto_introducido = findViewById(R.id.texto_introducido);
        textoSaludo = findViewById(R.id.texto_bienvenida);
        botonPulsar.setOnClickListener ({
            var texto = texto_introducido.text
            textoSaludo.setText(texto)
            texto_introducido.setText("")
            Log.v("ciclo_vida","Botón pulsado")

        })
       /* botonPasar.setOnClickListener ({ view: View ->
            Toast.makeText(applicationContext, "Toast completada", Toast.LENGTH_SHORT).show()
        })*/
        botonPasar.setOnClickListener ({ view: View ->
           var notificacion = Snackbar.make(view,"Snack completado",Snackbar.LENGTH_INDEFINITE)
            notificacion.setAction("Seguro que quieres cerrar?", {
                notificacion.dismiss()
            })
            notificacion.show()
        })


    }
    override fun onStart() {
        super.onStart()

        botonPulsar = findViewById(R.id.boton_pulsar)
        Log.v("ciclo_vida","Método onStart ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
    }

    override fun onResume() {
        super.onResume()

        botonPulsar = findViewById(R.id.boton_pulsar)
        Log.v("ciclo_vida","Método onResume ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
    }

    override fun onPause() {
        super.onPause()

        botonPulsar = findViewById(R.id.boton_pulsar)
        Log.v("ciclo_vida","Método onPause ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
    }


}