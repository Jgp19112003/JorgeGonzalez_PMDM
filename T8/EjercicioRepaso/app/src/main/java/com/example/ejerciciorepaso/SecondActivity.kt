package com.example.ejerciciorepaso

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciorepaso.databinding.ActivityMainBinding
import com.example.ejerciciorepaso.databinding.SecondActivityBinding
import com.example.ejerciciorepaso.dialogs.DialogoDetalle
import com.example.ejerciciorepaso.model.Coche
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondActivity : AppCompatActivity(), RecyclerCoches.OnRecyclerCocheSelected, DialogoDetalle.OnDialogCoche {

    private lateinit var binding: SecondActivityBinding
    private var correo: String? = null
    private var uid: String? = null
    private lateinit var adaptadorRecycler: RecyclerCoches
    private lateinit var adaptadorSpinner: ArrayAdapter<CharSequence>
    private lateinit var fDataBase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fDataBase = FirebaseDatabase.getInstance("https://fir-ces-jgp-default-rtdb.firebaseio.com/")
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adaptadorRecycler = RecyclerCoches(this, ArrayList<Coche>())
        binding.recyclerCoches.adapter = adaptadorRecycler;
        binding.recyclerCoches.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL, false
        )
        initGUI()
    }

    private fun initGUI() {
        adaptadorSpinner = ArrayAdapter.createFromResource(applicationContext,R.array.color_array,android.R.layout.simple_spinner_item)
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerColor.adapter = adaptadorSpinner
        correo = intent.extras?.getString("correo")
        uid = intent.extras?.getString("uid")
        fDataBase.getReference("usuarios")
            .child(uid.toString())
            .child("nombre").setValue(correo)

        binding.textoUsuario.text = binding.textoUsuario.text.toString() + correo

        binding.botonAgregarCoche.setOnClickListener {
            if (!binding.editModelo.text.isEmpty() && !binding.editCv.text.isEmpty()) {
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

                fDataBase.getReference("usuarios")
                    .child(uid.toString())
                    .child("coche")
                    .child(binding.editModelo.text.toString())
                    .child("color").setValue(binding.spinnerColor.selectedItem.toString())
            }
        }
        binding.botonVerMisCoches.setOnClickListener {
            adaptadorRecycler.listaDatos.clear()
            fDataBase.getReference("usuarios")
                .child(uid!!)
                .child("coche")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (i in snapshot.children) {
                            val coche = i.getValue(Coche::class.java)
                            Log.v("coche", coche!!.toString())
                            adaptadorRecycler.addCoche(coche)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        }
    }

    override fun onCocheSelected(coche: Coche) {
        DialogoDetalle.newInstance(coche.modelo,coche.cv.toString(),coche.color).show(supportFragmentManager,"")
    }

    override fun onDialogCoche(coche: Coche) {
        TODO("Not yet implemented")
    }
}