package com.example.hobbies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hobbies.R
import com.example.hobbies.model.Elemento

class AdapterLista(private var lista: ArrayList<Elemento>, private var context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Any {
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view: View = LayoutInflater.from(context).inflate(R.layout.item_lista,p2,false)

        var elemento: Elemento = lista[p0]

        var textoNombre: TextView = view.findViewById(R.id.texto_nombre)
        var textoDescripcion: TextView = view.findViewById(R.id.texto_descripcion)
        var imagenElemento: ImageView = view.findViewById(R.id.imagen_elemento)

        textoNombre.setText(elemento.nombre)
        textoDescripcion.setText(elemento.descripcion)
        imagenElemento.setImageResource(elemento.imagen)

        return view

    }
}