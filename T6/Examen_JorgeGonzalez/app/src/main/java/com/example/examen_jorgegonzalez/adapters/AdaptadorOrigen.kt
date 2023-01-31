package com.example.examen_jorgegonzalez.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.examen_jorgegonzalez.R
import com.example.examen_jorgegonzalez.models.Ciudad

class AdaptadorOrigen (var listaCiudades: ArrayList<Ciudad>, var contexto: Context) : BaseAdapter(){


    override fun getCount(): Int {
        return listaCiudades.size
    }

    override fun getItem(position: Int): Any {
        return listaCiudades.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // retona la vista (fila) ya rellena con los datos que estas
        // en una posición indicada -> p0
        // para poder rellenar la fila -> XML

        var vista: View =  LayoutInflater.from(contexto).inflate(R.layout.vista_spinnerorigen,parent,false)

        var nombre: TextView = vista.findViewById(R.id.texto_ciudad);
        var imagen: ImageView = vista.findViewById(R.id.imagen_ciudad);

        var ciudad = listaCiudades.get(position)
        nombre.text = ciudad.nombre
        imagen.setImageResource(ciudad.imagen)

        return vista;
    }
}