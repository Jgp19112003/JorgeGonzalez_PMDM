package com.example.login_firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.login_firebase.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.oAuthCredential

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

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
        Glide.with(requireActivity())
            .load("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png")
            .placeholder(R.drawable.user).into(binding.imagenLogin)

        //if login success cambio pantalla
        binding.botonLogin.setOnClickListener {
            if (!binding.editNombre.text.isEmpty() && !binding.editPassword.text.isEmpty()) {
                auth.signInWithEmailAndPassword(
                    binding.editNombre.text.toString(),
                    binding.editPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val bundle = Bundle()
                        bundle.putString("nombre", binding.editNombre.text.toString())
                        bundle.putString("uid", auth.currentUser!!.uid)
                        findNavController().navigate(
                            R.id.action_FirstFragment_to_secondActivity,
                            bundle
                        )
                    } else {
                        Snackbar.make(view, "Los datos son incorrectos", Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
        binding.botonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}