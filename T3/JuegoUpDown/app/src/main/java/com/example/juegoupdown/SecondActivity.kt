package com.example.juegoupdown

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(){

    var puntos: Int = 0
    var carta_futura: Int = 0
    val cartas: Array<Int> = arrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
        R.drawable.c7,
        R.drawable.c8,
        R.drawable.c9,
        R.drawable.c10,
        R.drawable.c11,
        R.drawable.c12,
        R.drawable.c13
    )
    lateinit var bmayor: ImageButton
    lateinit var bmenor: ImageButton
    lateinit var imagenCarta: ImageView
    lateinit var textoPuntos: TextView

    lateinit var nombreRecuperado: String;
    var contador: Int? = null;
    var aleatorio: Int? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        instancias()
        recuperarDatos()
        iniciarUI()
    }

    private fun iniciarUI() {

        val texto = nombreRecuperado;
        var notificacion =
            Snackbar.make(bmayor, "Bienvenido " + texto, Snackbar.LENGTH_INDEFINITE)

        notificacion.setAction("Empezar") {
            // pasar de activity
            // INTENT -> acciones
            cartaRoll()
        }
        notificacion.show()
    }

    private fun recuperarDatos() {

        var bundleRecuperado: Bundle? = intent.extras;
        nombreRecuperado = bundleRecuperado?.getString("nombre", "Jugador").toString()

    }

    private fun instancias(){
        bmayor = findViewById(R.id.bmayor)
        bmenor = findViewById(R.id.bmenor)
        imagenCarta = findViewById(R.id.imagenCarta)
        textoPuntos = findViewById(R.id.textoPuntos)

        bmayor.setOnClickListener(){
            cartaRoll()
            if (contador!! < aleatorio!!){
                puntos++
                textoPuntos.setText("Puntos: "+ puntos.toString())
                contador = aleatorio

            } else if (contador!! == aleatorio){

            } else if (contador!! > aleatorio!!){
                textoPuntos.setText("Has perdido con: " + puntos + " puntos.")
                bmayor.isClickable = false
                bmenor.isClickable = false
            }
        }
        bmenor.setOnClickListener(){
            cartaRoll()
            if (contador!! > aleatorio!!){
                puntos++
                textoPuntos.setText("Puntos: "+ puntos.toString())
                contador = aleatorio
            } else if (contador!! == aleatorio){

            }else if (contador!! < aleatorio!!){
                textoPuntos.setText("Has perdido con: " + puntos + " puntos.")
                bmayor.isClickable = false
                bmenor.isClickable = false
            }
        }
    }
    private fun cartaRoll(){
        aleatorio = (Math.random() * 13).toInt()
        carta_futura = cartas[aleatorio!!]
        if (contador == null){
            contador = aleatorio
        }

        imagenCarta.setImageResource(carta_futura)

    }
}



