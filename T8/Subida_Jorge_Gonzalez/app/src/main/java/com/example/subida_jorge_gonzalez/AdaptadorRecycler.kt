package com.example.subida_jorge_gonzalez

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<String>):
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var mensaje: TextView


        init {
            mensaje = view.findViewById(R.id.texto_mensaje)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.vista_recycler,parent,false)
        return MyHolder(view)
    }

    fun addMensajes(lista_mensajes: ArrayList<String>){
        listaDatos.clear()
        lista_mensajes.forEach{
            this.listaDatos.add(it)
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var mensaje: String = listaDatos.get(position) as String
        holder.mensaje.setText(mensaje.toString())
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }


}
