package com.example.examen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examen.databinding.FirstFragmentBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FirstFragment  : Fragment() {



    private var _binding: FirstFragmentBinding? = null
    private lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        _binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.botonLogin.setOnClickListener {
            if (!binding.editCorreo.text.isEmpty() || !binding.editPassword.text.isEmpty()){
                auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editPassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        //Pasar elementos a la otra pantalla
                        val bundle = Bundle()
                        bundle.putString("correo",binding.editCorreo.text.toString())
                        bundle.putString("uid",auth.currentUser!!.uid)
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondActivity,bundle)
                    }
                }
            } else {
                Snackbar.make(binding.root, "Datos incorrectos", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        binding.botonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}