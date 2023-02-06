package com.example.inicio.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.FragmentHeaderBinding
import com.google.android.material.snackbar.Snackbar

class FragmentHeader: Fragment() {

    private lateinit var binding: FragmentHeaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHeaderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonHeader.setOnClickListener {
            //Snackbar.make(binding.root,"Primera app con fragments",Snackbar.LENGTH_SHORT)
            crearDialogoAyuda().show()
        }
    }

    fun crearDialogoAyuda() : AlertDialog{
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Primera app con fragments")
        return builder.create()
    }

}