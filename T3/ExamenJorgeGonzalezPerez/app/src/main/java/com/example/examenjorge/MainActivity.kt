package com.example.examenjorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.examenjorge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        instancias()
        acciones()
    }

    private fun acciones() {
        binding.botonComprobador.setOnClickListener(this)
        binding.botonModelo.setOnClickListener(this)
    }

    private fun instancias() {

    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.botonComprobador -> {
                val intent: Intent = Intent(applicationContext, ThirdActivity::class.java)

                startActivity(intent)
            }

            R.id.botonModelo -> {

                val intent: Intent = Intent(applicationContext, SecondActivity::class.java)

                startActivity(intent)
            }
        }
    }
}

