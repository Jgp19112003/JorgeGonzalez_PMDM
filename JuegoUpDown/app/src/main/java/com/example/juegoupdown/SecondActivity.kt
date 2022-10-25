package com.example.juegoupdown

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {


    var carta_aleatoria: Int = 0
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
    lateinit var nombreRecuperado: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        recuperarDatos()
        iniciarUI()
    }

    private fun iniciarUI() {


        val texto = nombreRecuperado;
        var notificacion =
            Snackbar.make(, "Bienvenido " + texto, Snackbar.LENGTH_INDEFINITE)

        notificacion.setAction("Empezar") {
            // pasar de activity
            // INTENT -> acciones

            for (item: Int in cartas) {
                var aleatorio: Int
                aleatorio = (Math.random() * 14).toInt()
                carta_aleatoria = cartas[aleatorio]
            }
        }
        notificacion.show()
    }

    private fun recuperarDatos() {

        var bundleRecuperado: Bundle? = intent.extras;
        nombreRecuperado = bundleRecuperado?.getString("nombre", "Jugador").toString()

    }
}



