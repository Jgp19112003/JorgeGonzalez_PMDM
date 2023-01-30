package com.example.menus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menus.R
import com.example.menus.model.Asignatura

class AdaptadorAsignatura (var listaAsignaturas: ArrayList<Asignatura>, var contexto: Context): RecyclerView.Adapter<AdaptadorAsignatura.MyHolder>() {
    private lateinit var listener: AdaptadorAsignatura.OnRecyclerAsignaturaListener

    init {
        listener = contexto as AdaptadorAsignatura.OnRecyclerAsignaturaListener
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemNombre: TextView

        init {
            itemNombre =itemView.findViewById(R.id.nombre_item);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorAsignatura.MyHolder {

        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: AdaptadorAsignatura.MyHolder, position: Int) {

        val asignatura = listaAsignaturas[position]
        holder.itemNombre.setText(asignatura.siglas)

        holder.itemNombre.setOnClickListener{
            listener.onAsignaturaSelected(asignatura)
        }
    }

    fun cambiarLista(listaNueva: ArrayList<Asignatura>){
        this.listaAsignaturas = listaNueva;
        notifyDataSetChanged()
    }

    fun addAsignatura(asignatura: Asignatura){
        this.listaAsignaturas.add(asignatura)
        this.notifyItemInserted(listaAsignaturas.size-1)
    }

    fun clearAsignaturas(){
        this.listaAsignaturas.clear();
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listaAsignaturas.size
    }

    interface OnRecyclerAsignaturaListener{
        fun onAsignaturaSelected(asignatura: Asignatura)
    }
}