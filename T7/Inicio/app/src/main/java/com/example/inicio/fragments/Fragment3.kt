package com.example.inicio.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.R
import com.example.inicio.adapters.AdaptadorUsuarios
import com.example.inicio.databinding.Fragment2Binding
import com.example.inicio.databinding.Fragment3Binding
import com.example.inicio.model.Usuario

class Fragment3 : Fragment() {

    private lateinit var binding: Fragment3Binding
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios;
    private lateinit var listaUsuarios: ArrayList<Usuario>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        instancias()
        configurarRecycler()
    }

    private fun instancias() {
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Borja", "Martin",66666666,R.drawable.male,"M"))
        adaptadorUsuarios = AdaptadorUsuarios(listaUsuarios, requireContext());
    }
    private fun configurarRecycler() {
        binding.listaRecycler.adapter = adaptadorUsuarios;
        binding.listaRecycler.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
    }
}