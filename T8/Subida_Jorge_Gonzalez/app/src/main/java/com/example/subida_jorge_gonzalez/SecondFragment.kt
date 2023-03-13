package com.example.subida_jorge_gonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.subida_jorge_gonzalez.databinding.FragmentSecondBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var fDatabase: FirebaseDatabase
    private var uid: String?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fDatabase = FirebaseDatabase.getInstance("https://fir-ces-jgp-default-rtdb.firebaseio.com/")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        startGUI()
        return binding.root

    }

    private fun startGUI() {
        //uid = requireArguments().getString("uid")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        /*fDatabase.getReference("usuarios")
            .child(uid!!)
            .child("logoncount")
            .setValue(logoncount)

        fDatabase.getReference("productos")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        val producto = i.getValue(Producto::class.java)
                        adaptadorRecycler.addProducto(producto!!)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // error en la comunicacion
                }

            })*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}