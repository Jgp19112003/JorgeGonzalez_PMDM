package com.example.subida_jorge_gonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.subida_jorge_gonzalez.databinding.FragmentSecondBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var fDatabase: FirebaseDatabase
    private var uid: String?= null
    private var mensajes: Int = 0
    private var contador: Int = 0
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var lista_mensajes: ArrayList<String>
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fDatabase = FirebaseDatabase.getInstance("https://fir-ces-jgp-default-rtdb.firebaseio.com/")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        adaptadorRecycler = AdaptadorRecycler(requireContext(),ArrayList<String>())
        binding.recyclerMensajes.adapter = adaptadorRecycler;
        binding.recyclerMensajes.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        startGUI()
        return binding.root

    }

    private fun startGUI() {
        uid = requireArguments().getString("uid")
        lista_mensajes = ArrayList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fDatabase.getReference("usuarios")
            .child(uid!!)

        binding.botonEnviar.setOnClickListener {
            lista_mensajes.clear()
            mensajes++

            fDatabase.getReference("usuarios")
                .child(uid!!)
                .child("Nº Mensajes")
                .setValue(mensajes)

            fDatabase.getReference("mensajes")
                .child("mensaje $contador")
                .setValue(binding.editMensaje.text.toString())
        }

        fDatabase.getReference("mensajes")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        lista_mensajes.add(i.value.toString())
                        adaptadorRecycler.addMensajes(lista_mensajes)
                        contador++
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}