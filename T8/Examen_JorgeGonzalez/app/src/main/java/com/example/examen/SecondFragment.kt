package com.example.examen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen.adapters.AdaptadorRecycler
import com.example.examen.databinding.FirstFragmentBinding
import com.example.examen.databinding.SecondFragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondFragment : Fragment(){

    private var _binding: SecondFragmentBinding? = null
    private lateinit var fDatabase: FirebaseDatabase
    private val binding get() = _binding!!
    private var uid: String?= null
    private var logoncount: Int?= null
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var lista_ptoductos: ArrayList<Producto>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fDatabase = FirebaseDatabase.getInstance("https://fir-ces-jgp-default-rtdb.firebaseio.com/")
        _binding = SecondFragmentBinding.inflate(inflater, container, false)
        uid = savedInstanceState!!.getString("uid")
        logoncount = savedInstanceState.getInt("logoncount")

        adaptadorRecycler = AdaptadorRecycler(requireContext(),ArrayList<Producto>())
        binding.recyclerProductos.adapter = adaptadorRecycler;
        binding.recyclerProductos.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        startGUI()
        return binding.root
    }

    private fun startGUI() {
        uid = requireArguments().getString("uid")
        logoncount = requireArguments().getInt("logoncount")
        lista_ptoductos = ArrayList()
        Log.v("salida",uid.toString() + logoncount.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fDatabase.getReference("usuarios")
            .child(uid!!)
            .child("logoncount")
            .setValue(logoncount)

        fDatabase.getReference("productos")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        val producto = i.getValue(Producto::class.java)
                        adaptadorRecycler.addProducto(producto!!)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // error en la comunicacion
                }

            })
    }
}