package com.example.examen

import android.widget.ImageView

data class Producto (var title: String?= null, var thumbnail: String?= null, var price: Int?=null){
    override fun toString(): String {
        return title +" "+thumbnail+" "+price
    }
}