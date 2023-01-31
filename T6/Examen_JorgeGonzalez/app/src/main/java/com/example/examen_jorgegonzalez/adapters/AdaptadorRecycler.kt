package com.example.examen_jorgegonzalez.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_jorgegonzalez.R
import com.example.examen_jorgegonzalez.models.Ciudad
import com.example.examen_jorgegonzalez.models.Viaje
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<Viaje>):
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView
        lateinit var boton_verDetalle: Button


        init {
            nombre = view.findViewById(R.id.texto_ciudad)
            imagen = view.findViewById(R.id.imagen_ciudad)
            boton_verDetalle = view.findViewById(R.id.boton_verDetalle)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.vista_recycler,parent,false)
        return MyHolder(view)
    }

    fun addViaje(viaje: Viaje){
        this.listaDatos.add(viaje)
        this.notifyItemInserted(listaDatos.size-1)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var viaje: Viaje = listaDatos.get(position) as Viaje
        holder.imagen.setImageResource(viaje.imagen)
        holder.nombre.setText(viaje.nombre)

        holder.boton_verDetalle.setOnClickListener {
            Snackbar.make(
                holder.nombre,
                viaje.toString(),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnRecyclerCiudadSelected{
        fun onCiudadSelected(ciudad: Ciudad)
    }
}