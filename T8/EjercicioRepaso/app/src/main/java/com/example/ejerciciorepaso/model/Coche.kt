package com.example.ejerciciorepaso.model

data class Coche (var cv: Int?=null , var modelo: String?=null, var color: String?=null) {
    override fun toString(): String {
        return modelo + " " + cv
    }
}