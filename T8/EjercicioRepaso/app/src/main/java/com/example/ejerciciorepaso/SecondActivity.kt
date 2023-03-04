package com.example.ejerciciorepaso

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciorepaso.databinding.ActivityMainBinding
import com.example.ejerciciorepaso.databinding.SecondActivityBinding
import com.google.firebase.database.FirebaseDatabase

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding
    private var nombre: String? = null
    private var uid: String? = null
    private lateinit var fDataBase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fDataBase = FirebaseDatabase.getInstance("https://fir-ces-jgp-default-rtdb.firebaseio.com/")
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI()
    }

    private fun initGUI() {
        nombre = intent.extras?.getString("nombre")
        uid = intent.extras?.getString("uid")

        fDataBase.getReference("usuarios")
            .child(uid.toString())
            .child("nombre").setValue(nombre)

        binding.textoUsuario.text = binding.textoUsuario.text.toString() + nombre

        binding.botonAgregarCoche.setOnClickListener {
            if (!binding.editModelo.text.isEmpty() && !binding.editCv.text.isEmpty()){
                fDataBase.getReference("usuarios")
                    .child(uid.toString())
                    .child("coche")
                    .child(binding.editModelo.text.toString())
                    .child("modelo").setValue(binding.editModelo.text.toString())

                fDataBase.getReference("usuarios")
                    .child(uid.toString())
                    .child("coche")
                    .child(binding.editModelo.text.toString())
                    .child("cv").setValue(binding.editCv.text.toString().toInt())

                //snapshot
            }
        }
    }
}