package com.example.ejerciciorepaso.model

data class Usuario (var correo: String?=null, var edad: Int?=null, var coche: String?=null,) {
    override fun toString(): String {
        return correo + " " + edad
    }
}