package com.example.examenjorge

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdaptadorLista(private var lista: ArrayList<Coche>, private var context: Context) : BaseAdapter() {

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

        var coche: Coche = lista[p0]

        var textoNombre: TextView = view.findViewById(R.id.textoNombre)


        textoNombre.setText(coche.nombre)

        return view

    }
}