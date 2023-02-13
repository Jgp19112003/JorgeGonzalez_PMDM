package com.example.inicio.model

data class Usuario (var nombre: String, var apellido: String, var telefono: Int , var imagen: Int, var sexo: String){
    override fun toString(): String {
        return super.toString()
    }
}