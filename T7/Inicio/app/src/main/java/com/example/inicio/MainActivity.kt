package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.ActivityMainBinding
import com.example.inicio.fragments.Fragment1
import com.example.inicio.fragments.Fragment2

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
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
                val fm = supportFragmentManager
                var ft = fm.beginTransaction()
                ft.replace(binding.sitioFragments.id, Fragment2())
                ft.commit()
            }
            binding.botonF3.id -> {

            }
        }
    }
}