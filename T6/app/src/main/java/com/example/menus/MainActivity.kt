package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.menus.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_op1 ->  {
                Snackbar.make(binding.root,"Pulsado item1",Snackbar.LENGTH_INDEFINITE).show()
            }
            R.id.menu_op2 ->  {
                Snackbar.make(binding.root,"Pulsado item2",Snackbar.LENGTH_INDEFINITE).show()
            }
            R.id.menu_op1_1 ->  {
                Snackbar.make(binding.root,"Pulsado item2 opcion1",Snackbar.LENGTH_INDEFINITE).show()
            }
            R.id.menu_op1_2 ->  {
                Snackbar.make(binding.root,"Pulsado item2 opcion2",Snackbar.LENGTH_INDEFINITE).show()
            }
        }
        return true
    }
}