package com.example.practicaexamen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.SpinnerAdapter
import android.widget.TextView

class AdaptadorPersonalizado (var listaElementos: ArrayList<Lenguaje>, var contexto: Context): BaseAdapter() {
    override fun getCount(): Int {
        return listaElementos.size
    }

    override fun getItem(p0: Int): Any {
        return listaElementos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_spinner,p2,false)

        var nombre: TextView = vista.findViewById(R.id.texto_lenguaje)
        var imagen: ImageView = vista.findViewById(R.id.imagen_lenguaje)
        var elemento = listaElementos[p0]
        nombre.text = elemento.nombre
        imagen.setImageResource(elemento.imagen)
        return vista
    }
}