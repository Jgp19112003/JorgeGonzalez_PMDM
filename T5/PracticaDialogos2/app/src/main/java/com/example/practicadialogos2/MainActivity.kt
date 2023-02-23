package com.example.practicadialogos3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicadialogos3.adapters.AdaptadorRecycler
import com.example.practicadialogos3.databinding.ActivityMainBinding
import com.example.practicadialogos3.model.Usuario

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adaptadorRecycler: AdaptadorRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones()
    }


    private fun instancias() {
        adaptadorRecycler = AdaptadorRecycler(this, ArrayList())
        binding.recyclerTrabajador.adapter = adaptadorRecycler
        binding.recyclerTrabajador.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL, false)



        var adapter = ArrayAdapter.createFromResource(this,R.array.puestos_array,android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPuesto.adapter = adapter
    }
    private fun acciones() {
        binding.botonAdd.setOnClickListener {
            adaptadorRecycler.addUsuario(Usuario(binding.nombreEdit.text.toString(),binding.apellidosEdit.text.toString(),binding.correoEdit.text.toString(),binding.edadEdit.toString(),binding.spinnerPuesto.selectedItem.toString()))
        }
    }
}