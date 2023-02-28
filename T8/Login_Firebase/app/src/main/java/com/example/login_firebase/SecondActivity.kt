package com.example.login_firebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login_firebase.databinding.SecondActivityBinding
import com.google.firebase.database.FirebaseDatabase

class SecondActivity : AppCompatActivity() {

    private var nombre: String? = null
    private var uid: String? = null
    private lateinit var fDataBase: FirebaseDatabase
    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fDataBase =
            FirebaseDatabase.getInstance("https://fir-ces-jgp-default-rtdb.firebaseio.com/")
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI()

        // nada mas arrancar
        // en un textview de la pantalla aparezca bienvenido: nombre usuario
        // en el formulario al agregar un dato
        // en el nodo del usuario
        // crear un nodo productos_fav
        // nombre_producto
        // nombre: nombre del edit
        // valor: valor del edit

        // quiero que se guarde en un nodo
        // usuarios
        // uid
        // nombre: valor

    }

    private fun initGUI() {
        nombre = intent.extras!!.getString("nombre")
        uid = intent.extras!!.getString("uid")

        fDataBase.getReference("usuarios")
            .child(uid.toString())
            .child("nombre")
            .setValue(nombre)

        binding.botonAgregar.setOnClickListener {
            fDataBase.getReference("usuarios").child(uid.toString()).child("productos_fav").child("nombre").setValue(binding.editNombreProducto.text.toString())
            fDataBase.getReference("usuarios").child(uid.toString()).child("productos_fav").child("valor").setValue(binding.editValor.text.toString())
        }

    }
}