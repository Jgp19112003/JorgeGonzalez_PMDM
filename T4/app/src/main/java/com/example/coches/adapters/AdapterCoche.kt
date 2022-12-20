package com.example.coches.adapters

import android.content.Context
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.coches.R
import com.example.coches.model.Coche

class AdapterCoche(var context: Context, var lista: ArrayList<Coche>) :
    RecyclerView.Adapter<AdapterCoche.MyHolder>() {
    var funcionComunicar: ((coche: Coche) -> Unit)? = null

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagen: ImageView
        var modelo: TextView
        var boton: Button

        init {
            imagen = itemView.findViewById(R.id.imagen_item)
            modelo = itemView.findViewById(R.id.modelo_item)
            boton = itemView.findViewById(R.id.boton_item)
        }
    }

    fun cambiarLista(listaNueva: ArrayList<Coche>){
        this.lista = listaNueva
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val coche = lista.get(position)
        holder.modelo.text = coche.modelo
        holder.imagen.setImageResource(coche.imagen)
        funcionComunicar?.invoke(coche)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}