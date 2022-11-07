package com.example.calculadoraandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraandroid.databinding.ActivityMainBinding
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val tipoOperacion: Int? = null
    private var resultado: Double? = null
    private var op2: Double? = null
    private var op1: Double? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        instancias()
        acciones()
    }

    private fun instancias() {
        binding.b0?.setOnClickListener(this)
        binding.b1?.setOnClickListener(this)
        binding.b2?.setOnClickListener(this)
        binding.b3?.setOnClickListener(this)
        binding.b4?.setOnClickListener(this)
        binding.b5?.setOnClickListener(this)
        binding.b6?.setOnClickListener(this)
        binding.b7?.setOnClickListener(this)
        binding.b8?.setOnClickListener(this)
        binding.b9?.setOnClickListener(this)
        binding.bDiv?.setOnClickListener(this)
        binding.bMultiplicacion?.setOnClickListener(this)
        binding.bResta?.setOnClickListener(this)
        binding.bSuma?.setOnClickListener(this)
        binding.bIgual?.setOnClickListener(this)
        binding.bAC?.setOnClickListener(this)
        binding.bNegativo?.setOnClickListener(this)
        binding.bPorcentaje?.setOnClickListener(this)
        binding.bPunto?.setOnClickListener(this)
        binding.bPunto?.setOnClickListener(this)
        binding.textoOperacion?.setOnClickListener(this)
    }

    private fun acciones() {

    }
    private fun factorial(n: Double): Double{
        var dato: Double = 1.0
        for (i in 1..n.toInt()){
            resultado = resultado?.times(i)
        }
        return resultado!!
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.bIgual -> {

                when (tipoOperacion) {
                    0 -> {
                        op2 = (binding.textoOperacion?.text).toString().toDouble();
                        resultado = op1?.plus(op2!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    1 -> {
                        op2 = (binding.textoOperacion?.text).toString().toDouble();
                        resultado = op1?.minus(op2!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    2 -> {
                        op2 = (binding.textoOperacion?.text).toString().toDouble();
                        resultado = op1?.times(op2!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    3 -> {
                        op2 = (binding.textoOperacion?.text).toString().toDouble();
                        resultado = op1?.div(op2!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    4 -> {
                        op2 = (binding.textoOperacion?.text).toString().toDouble();
                        resultado = op1?.rem(op2!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    5 -> {
                        resultado = factorial(op1!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    6 -> {
                        resultado = sin(op1!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    7 -> {
                        resultado = sqrt(op1!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    8 -> {
                        op2 = (binding.textoOperacion?.text).toString().toDouble();
                        resultado = (op1!!).pow(op2!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }

                    9 -> {
                        resultado = ln(op1!!);
                        binding.textoOperacion?.setText(resultado.toString());
                    }
                }
            }
            R.id.b0 ->{
                    binding.textoOperacion!!.setText(binding.textoOperacion?.text!!.append(binding.b0?.text));
            }
        }
    }
}

