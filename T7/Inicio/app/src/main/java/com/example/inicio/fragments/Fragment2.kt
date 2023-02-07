package com.example.inicio.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

    companion object{
        fun newInstance(mensaje: String): Fragment2 {


            val args = Bundle()
            args.putString("mensaje", mensaje)
            val fragment = Fragment2()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        acciones()
    }

    private fun acciones() {
        var mensaje = this.arguments?.get("mensaje")
        binding.textoNombre.text = mensaje.toString()
    }
}