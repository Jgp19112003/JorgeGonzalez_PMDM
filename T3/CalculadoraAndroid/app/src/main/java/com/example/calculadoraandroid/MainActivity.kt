package com.example.calculadoraandroid


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraandroid.databinding.ActivityMainBinding
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var tipoOperacion: Int? = null
    private var resultado: Double? = null
    private var op2: Double? = null
    private var op1: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        instancias()
        acciones()
    }

    private fun instancias() {
        binding.b0.setOnClickListener(this)
        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
        binding.b3.setOnClickListener(this)
        binding.b4.setOnClickListener(this)
        binding.b5.setOnClickListener(this)
        binding.b6.setOnClickListener(this)
        binding.b7.setOnClickListener(this)
        binding.b8.setOnClickListener(this)
        binding.b9.setOnClickListener(this)
        binding.bDiv.setOnClickListener(this)
        binding.bMultiplicacion.setOnClickListener(this)
        binding.bResta.setOnClickListener(this)
        binding.bSuma.setOnClickListener(this)
        binding.bIgual.setOnClickListener(this)
        binding.bAC.setOnClickListener(this)
        binding.bNegativo.setOnClickListener(this)
        binding.bPorcentaje.setOnClickListener(this)
        binding.bPunto.setOnClickListener(this)
        binding.textoOperacion.setOnClickListener(this)
        binding.bFactorial?.setOnClickListener(this)
        binding.bRaiz?.setOnClickListener(this)
        binding.bExponente?.setOnClickListener(this)
        binding.bE?.setOnClickListener(this)
        binding.bLog?.setOnClickListener(this)

    }

    private fun acciones() {

    }

    fun factorial(num: Double){
        var resultado = 1
        for (i in 2..num.toInt()) resultado *= i
        binding.textoOperacion.setText(resultado.toString());
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.bIgual -> {

                when (tipoOperacion) {
                    0 -> {
                        op2 = (binding.textoOperacion.text).toString().toDouble();
                        resultado = op1?.plus(op2!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    1 -> {
                        op2 = (binding.textoOperacion.text).toString().toDouble();
                        resultado = op1?.minus(op2!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    2 -> {
                        op2 = (binding.textoOperacion.text).toString().toDouble();
                        resultado = op1?.times(op2!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    3 -> {
                        op2 = (binding.textoOperacion.text).toString().toDouble();
                        resultado = op1?.div(op2!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    4 -> {
                        op2 = (binding.textoOperacion.text).toString().toDouble();
                        resultado = op1?.rem(op2!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    5 -> {
                        factorial(op1!!);
                    }

                    7 -> {
                        resultado = sqrt(op1!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    8 -> {
                        op2 = (binding.textoOperacion.text).toString().toDouble();
                        resultado = (op1!!).pow(op2!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }

                    9 -> {
                        resultado = ln(op1!!);
                        binding.textoOperacion.setText(resultado.toString());
                    }
                }
            }
            R.id.b0 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b0.text);
            }
            R.id.b1 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b1.text);
            }
            R.id.b2 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b2.text);
            }
            R.id.b3 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b3.text);
            }
            R.id.b4 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b4.text);
            }
            R.id.b5 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b5.text);
            }
            R.id.b6 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b6.text);
            }
            R.id.b7 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b7.text);
            }
            R.id.b8 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b8.text);
            }
            R.id.b9 -> {
                binding.textoOperacion.text = binding.textoOperacion.text!!.append(binding.b9.text);
            }
            R.id.bAC -> {
                binding.textoOperacion.setText("");
            }
            R.id.bNegativo -> {
                binding.textoOperacion.setText("-" + binding.textoOperacion.text);
            }
            R.id.bPunto -> {
                binding.textoOperacion.text = binding.textoOperacion!!.text.append(binding.bPunto?.text);
            }
            R.id.bE -> {
                binding.textoOperacion.setText(binding.textoOperacion.text!!.append("2.71828"));
            }
            R.id.bSuma -> {

                op1 = (binding.textoOperacion.text).toString().toDouble();
                tipoOperacion = 0;
                binding.textoOperacion.setText("");
            }
            R.id.bResta -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                tipoOperacion = 1;
                binding.textoOperacion.setText("");
            }
            R.id.bMultiplicacion -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                tipoOperacion = 2;
                binding.textoOperacion.setText("");
            }
            R.id.bDiv -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                tipoOperacion = 3;
                binding.textoOperacion.setText("");
            }
            R.id.bPorcentaje -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                binding.textoOperacion.text = binding.textoOperacion.text;
                binding.textoOperacion.setText("");
                tipoOperacion = 4;
            }

            R.id.bFactorial -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                binding.textoOperacion.setText("!" + binding.textoOperacion!!.text);
                tipoOperacion = 5;
            }

            R.id.bRaiz -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                binding.textoOperacion.setText("√" + binding.textoOperacion?.text);
                tipoOperacion = 7;
            }
            R.id.bExponente -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                tipoOperacion = 8;
                binding.textoOperacion.setText("");
            }
            R.id.bLog -> {
                op1 = (binding.textoOperacion.text).toString().toDouble();
                binding.textoOperacion.setText("ln()" + binding.textoOperacion?.text);
                tipoOperacion = 9;
            }
        }
    }
}

