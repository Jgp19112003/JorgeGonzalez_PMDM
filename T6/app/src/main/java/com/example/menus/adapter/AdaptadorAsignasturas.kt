package com.example.menus.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menus.R
import com.example.menus.dialogs.DialogoAdd
import com.example.menus.dialogs.DialogoDetails
import com.example.menus.model.Asignatura

class AdaptadorAsignaturas (var listaAsignaturas: ArrayList<Asignatura>, var contexto: Context): RecyclerView.Adapter<AdaptadorAsignaturas.MyHolder>() {

    private lateinit var listener: OnRecyclerAsignaturaListener

    init {
        listener = contexto as OnRecyclerAsignaturaListener
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemNombre: TextView

        init {
            itemNombre =itemView.findViewById(R.id.nombre_item);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val asignatura = listaAsignaturas[position]
        holder.itemNombre.setText(asignatura.siglas)

        holder.itemNombre.setOnClickListener{
            listener.onAsignaturaSelected(asignatura)
        }
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