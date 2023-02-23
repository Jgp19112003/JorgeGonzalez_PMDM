package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        database = Firebase.database("https://fir-ces-jgp-default-rtdb.firebaseio.com/")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonCrear.setOnClickListener {
            auth.createUserWithEmailAndPassword("jgp19112003@gmail.com","admin1234")

        }
        binding.botonCrearNodo.setOnClickListener {
            database.getReference("ejemplo").setValue("Valor del nodo ejemplo")
            database.getReference("nodo_nuevo").child("ejemplo_hijo").child("nodo_agregar").setValue("Valor del nodo")
        }

    }
}