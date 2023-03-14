package com.example.subida_jorge_gonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.subida_jorge_gonzalez.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonLogin.setOnClickListener {
            if (!binding.editCorreo.text.isEmpty() && !binding.editPassword.text.isEmpty()) {
                auth.signInWithEmailAndPassword(
                    binding.editCorreo.text.toString(),
                    binding.editPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val bundle = Bundle()
                        bundle.putString("uid", auth.currentUser!!.uid)
                        findNavController().navigate(
                            R.id.action_FirstFragment_to_SecondFragment,
                            bundle
                        )
                    } else {
                        Snackbar.make(view, "Los datos son incorrectos", Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

