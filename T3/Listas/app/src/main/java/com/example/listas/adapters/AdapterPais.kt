package com.example.listas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listas.R
import com.example.spinner.modelo.Pais

class AdapterPais(private var lista: ArrayList<Pais>, private var context: Context) : BaseAdapter() {

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

        var pais: Pais = lista[p0]

        var textoNombre: TextView = view.findViewById(R.id.texto_pais)
        var textoEstrella: TextView = view.findViewById(R.id.texto_estrella)
        var escudoImagen: TextView = view.findViewById(R.id.imagen_pais)

        textoNombre.setText(pais.nombre)
        textoEstrella.setText(pais.estrella)
        escudoImagen.setText(pais.imagen)

        return view

    }
}