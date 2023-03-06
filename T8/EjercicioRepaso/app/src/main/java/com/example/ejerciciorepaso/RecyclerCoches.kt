package com.example.ejerciciorepaso

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciorepaso.model.Coche

class RecyclerCoches  (var contexto: Context, var listaDatos: ArrayList<Coche>):
    RecyclerView.Adapter<RecyclerCoches.MyHolder>() {
    private lateinit var listener: OnRecyclerCocheSelected
    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var modelo: TextView
        lateinit var cv: TextView



        init {
            modelo = view.findViewById(R.id.texto_modelo)
            cv = view.findViewById(R.id.texto_cv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.vista_recycler,parent,false)
        listener = contexto as OnRecyclerCocheSelected
        return MyHolder(view)
    }

    fun addCoche(coche: Coche){
        this.listaDatos.add(coche)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var coche: Coche = listaDatos.get(position) as Coche
        holder.modelo.text = holder.modelo.text.toString() + coche.modelo
        holder.cv.text = holder.cv.text.toString() + coche.cv
        holder.view.setOnClickListener {
            listener.onCocheSelected(coche)
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnRecyclerCocheSelected{
        fun onCocheSelected(coche: Coche)
    }
}