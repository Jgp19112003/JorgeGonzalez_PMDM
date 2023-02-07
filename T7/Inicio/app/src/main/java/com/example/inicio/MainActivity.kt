package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.ActivityMainBinding
import com.example.inicio.fragments.Fragment1
import com.example.inicio.fragments.Fragment2

class MainActivity : AppCompatActivity(), View.OnClickListener, Fragment1.OnFragmentUnoListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var mensaje: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)
        binding.botonF3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v!!.id){
            binding.botonF1.id -> {
                val fm = supportFragmentManager
                var ft = fm.beginTransaction()
                ft.replace(binding.sitioFragments.id, Fragment1())
                ft.commit()
            }
            binding.botonF2.id -> {

            }
            binding.botonF3.id -> {

            }
        }
    }

    override fun OnFragmentUnoListener(mensaje: String) {
        this.mensaje = mensaje
        val fm = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(binding.sitioFragments.id, Fragment2.newInstance(mensaje))
        ft.commit()
    }
}