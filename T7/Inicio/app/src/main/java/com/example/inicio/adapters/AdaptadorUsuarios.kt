package com.example.inicio.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.R
import com.example.inicio.model.Usuario

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context) :
    RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {

    private lateinit var listener: OnRecyclerUsuarioListener

    init {
        //OnRecyclerUsuarioListener = OnRecyclerUsuarioListener
        listener = contexto as OnRecyclerUsuarioListener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View = LayoutInflater.from(contexto).inflate(
            R.layout.lista_usuarios, parent,
            false
        ); // xml aspecto de cada fila
        return MyHolder(vista);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position)
        holder.textoNombre.setText(usuarioActual.nombre)
        if (usuarioActual.sexo.equals("M")){
            holder.imagenUsuario.setImageResource(R.drawable.male)
        } else{
            holder.imagenUsuario.setImageResource(R.drawable.female)
        }
        holder.layoutRecycler.setOnClickListener {
            listener.onUsuarioSelected(usuarioActual)
        }

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    interface OnRecyclerUsuarioListener{
        fun onUsuarioSelected(usuario: Usuario)
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textoNombre: TextView;
        var imagenUsuario: ImageView;
        var layoutRecycler: LinearLayout

        init {
            textoNombre = itemView.findViewById(R.id.nombre_usuario)
            imagenUsuario = itemView.findViewById(R.id.imagen_usuario)
            layoutRecycler = itemView.findViewById<LinearLayout>(R.id.layout_recycler)
        }

    }
}