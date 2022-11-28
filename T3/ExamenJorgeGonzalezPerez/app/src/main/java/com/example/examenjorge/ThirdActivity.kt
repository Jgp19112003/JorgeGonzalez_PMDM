package com.example.examenjorge

import android.R
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.examenjorge.databinding.ThirdActivityBinding
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity(){

    private lateinit var binding: ThirdActivityBinding
    lateinit var combustibles: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdActivityBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        instancias()
        acciones()
    }

    private fun instancias() {
        combustibles = ArrayList()
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,combustibles)
        binding.spinnerCombustible.adapter = adapter

        combustibles.add("Diesel")
        combustibles.add("Gasolina")
        combustibles.add("Hibrido")
        combustibles.add("Electrico")


        binding.spinnerCombustible.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }

    private fun acciones() {

    }
}