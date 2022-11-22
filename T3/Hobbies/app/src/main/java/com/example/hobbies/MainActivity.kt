package com.example.hobbies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.hobbies.databinding.ActivityMainBinding
import com.example.hobbies.databinding.SecondActivityBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        binding.botonHobbies.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.botonHobbies -> {
                var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                var datos: Bundle = Bundle()


                intent.putExtras(datos)
                startActivity(intent)
            }
        }
    }
}