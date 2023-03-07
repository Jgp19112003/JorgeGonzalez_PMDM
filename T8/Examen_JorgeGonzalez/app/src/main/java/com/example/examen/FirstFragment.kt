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
import com.google.firebase.database.FirebaseDatabase

class FirstFragment  : Fragment() {


    private var _binding: FirstFragmentBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!
     private var logoncount: Int = 0

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
        binding.botonLogin.setOnClickListener {
            if (!binding.editCorreo.text.isEmpty() || !binding.editPassword.text.isEmpty()){
                auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editPassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        logoncount++
                        val bundle = Bundle()
                        bundle.putInt("logoncount",logoncount)
                        bundle.putString("uid",auth.currentUser!!.uid)
                       // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
                    }
                }
            } else {
                Snackbar.make(binding.root, "AVISO: Datos incorrectos", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}