package com.example.estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.estados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;

        setContentView(view)
        contador = savedInstanceState?.getInt("contador")?:0
        acciones()
    }

    private fun acciones() {
        binding.bIncremento.setOnClickListener(this)
        binding.bDecremento.setOnClickListener(this)
        binding.bReset.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.bIncremento -> {
                contador++
            }
            R.id.bDecremento -> {
                contador--
            }
            R.id.bReset -> {
                contador = 0
            }
        }
        binding.textoNum.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("contador", contador)
    }


}