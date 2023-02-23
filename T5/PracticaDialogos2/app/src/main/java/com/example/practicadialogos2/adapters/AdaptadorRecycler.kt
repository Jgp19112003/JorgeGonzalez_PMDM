package com.example.practicadialogos3.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicadialogos3.R
import com.example.practicadialogos3.model.Usuario

class AdaptadorRecycler (var contexto: Context, var listaDatos: ArrayList<Usuario>): RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {


    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {
        lateinit var nombre: TextView
        lateinit var apellido: TextView

        init {
            nombre = view.findViewById(R.id.texto_nombre)
            apellido = view.findViewById(R.id.texto_apellido)
        }
    }

    fun addUsuario(usuario: Usuario){
        this.listaDatos.add(usuario)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.layout_recycler,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuario: Usuario = listaDatos.get(position)
        holder.nombre.setText(usuario.nombre)
        holder.apellido.setText(usuario.apellido)


        holder.view.setOnClickListener {
            //dialogo
        }
    }
}