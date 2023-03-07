package com.example.examen.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examen.Producto
import com.example.examen.R
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<Producto>):
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_producto)
            imagen = view.findViewById(R.id.imagen_producto)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.recycler_view,parent,false)
        return MyHolder(view)
    }

    fun addProducto(producto: Producto){
        this.listaDatos.add(producto)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var producto: Producto = listaDatos.get(position) as Producto

        //holder.imagen.setImageResource(producto.thumbnail)
        holder.nombre.setText(producto.title)

        Glide.with(holder.view)
            .load(producto.thumbnail)
            .into(holder.imagen)

        holder.view.setOnClickListener {
            Snackbar.make(
                holder.view,
                producto.price!!.toString(),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnRecyclerProductoSelected{
        fun onProductoSelected(producto: Producto)
    }
}