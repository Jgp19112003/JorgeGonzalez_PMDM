package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textoPeso: TextView
    lateinit var textoAltura: TextView
    lateinit var textoSexo: TextView
    lateinit var botonEvaluar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("ciclo_vida", "Método onCreate ejecutado")
        textoPeso = findViewById(R.id.textoPeso)
        textoAltura = findViewById(R.id.textoAltura)
        textoSexo = findViewById(R.id.textoSexo)
        botonEvaluar = findViewById(R.id.botonEvaluar)
        botonEvaluar.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        //Snackbar.make(p0!!,"Pulsado boton",Snackbar.LENGTH_SHORT).show();
        when (p0!!.id) {
            R.id.botonEvaluar -> {
                if (textoPeso.text.isEmpty() || textoAltura.text.isEmpty() || textoSexo.text.isEmpty()) {

                    var  notificacion = Snackbar.make(p0!!, "Faltan datos", Snackbar.LENGTH_SHORT)
                    notificacion.show()

                }else{
                    var notificacion =
                        Snackbar.make(p0!!, "Datos introducidos", Snackbar.LENGTH_INDEFINITE)
                        notificacion.setAction("Confirmar datos", {
                        // pasar de activity
                        // INTENT -> acciones
                        var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                        var datos: Bundle = Bundle()
                        datos.putString("nombre", textoPeso.text.toString())
                        datos.putString("nombre", textoAltura.text.toString())
                        datos.putString("nombre", textoSexo.text.toString())
                        intent.putExtras(datos)
                        startActivity(intent)
                        //startActivity(intent)
                        //finish()
                    })
                    notificacion.show()

                }
            }
        }
    }
}