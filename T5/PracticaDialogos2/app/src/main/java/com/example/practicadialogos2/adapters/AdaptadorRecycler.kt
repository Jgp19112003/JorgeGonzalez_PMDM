package com.example.practicadialogos2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicadialogos2.MainActivity
import com.example.practicadialogos2.dialogs.DialogoDetalle
import com.example.practicadialogos2.model.Usuario
import com.example.practicadialogos2.R

class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<Usuario>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {


    class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        lateinit var nombre: TextView
        lateinit var apellido: TextView
        lateinit var layout_detalle: LinearLayout

        init {
            nombre = view.findViewById(R.id.texto_nombre)
            apellido = view.findViewById(R.id.texto_apellido)
            layout_detalle = view.findViewById(R.id.layout_detalle)
        }
    }

    fun addUsuario(usuario: Usuario) {
        this.listaDatos.add(usuario)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(contexto).inflate(R.layout.layout_recycler, parent, false)  
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val usuario: Usuario = listaDatos.get(position)
        holder.nombre.setText(usuario.nombre)
        holder.apellido.setText(usuario.apellido)

        holder.layout_detalle.setOnClickListener {
            DialogoDetalle.newInstance(
                usuario.nombre,
                usuario.apellido,
                usuario.correo,
                usuario.edad,
                usuario.puesto
            ).show(/*supportfragmentmanager*/,"")
        }
    }
}