package com.example.inicio.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.Fragment1Binding
import com.google.android.material.snackbar.Snackbar

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding
    private lateinit var listener: OnFragmentUnoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentUnoListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        acciones()
    }

    private fun acciones() {
        binding.botonTexto.setOnClickListener {
            Snackbar.make(binding.botonTexto,binding.edittext1.text,Snackbar.LENGTH_LONG).show()
            listener.OnFragmentUnoListener(binding.edittext1.text.toString())
        }
    }

    interface OnFragmentUnoListener{
        fun OnFragmentUnoListener(mensaje: String)
    }
}