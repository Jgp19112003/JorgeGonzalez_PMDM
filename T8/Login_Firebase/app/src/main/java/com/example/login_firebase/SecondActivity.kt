package com.example.login_firebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login_firebase.databinding.SecondActivityBinding
import com.example.login_firebase.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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

        binding.textoNombre.text = "Hola $nombre"

        binding.botonAgregar.setOnClickListener {
            fDataBase.getReference("usuarios").child(uid.toString()).child("productos_fav").child(binding.editNombreProducto.text.toString()).child("nombre").setValue(binding.editNombreProducto.text.toString())
            fDataBase.getReference("usuarios").child(uid.toString()).child("productos_fav").child(binding.editNombreProducto.text.toString()).child("valor").setValue(binding.editValor.text.toString().toInt())
        }

        binding.botonRecuperar.setOnClickListener {
            fDataBase.getReference("usuarios")
                .child("productos_fav")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // snapshot --> estado actual
                        for (i in snapshot.children){
                            //i.key.toString()
                            val producto = i.getValue(Producto::class.java)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // error en la comunicacion
                    }

                })
        }

    }
}