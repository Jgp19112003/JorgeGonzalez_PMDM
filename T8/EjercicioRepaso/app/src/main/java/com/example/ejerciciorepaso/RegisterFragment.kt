package com.example.ejerciciorepaso

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejerciciorepaso.databinding.FragmentSecondBinding
import com.example.ejerciciorepaso.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var lista_usuarios = ArrayList<Usuario>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonResgistrarme.setOnClickListener {
            if (!binding.editCorreo.text.isEmpty() && !binding.editPassword.text.isEmpty() &&  !binding.editEdad.text.isEmpty()) {
                auth.createUserWithEmailAndPassword(
                    binding.editCorreo.text.toString(),
                    binding.editPassword.text.toString()
                ).addOnCompleteListener {
                    var usuario = Usuario(binding.editCorreo.text.toString(),binding.editEdad.text.toString().toInt())
                    lista_usuarios.add(usuario)
                    Log.v("usuario",usuario.toString())
                    findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                }
            } else {
                Snackbar.make(binding.root, "Fallo al crear el usuario", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}