package com.example.examen_jorgegonzalez.models

class Viaje (var imagen: Int, var nombre: String, var fechaOrigen: String,var fechaDestino: String) {
    override fun toString(): String {
        return "Nombre: "+ nombre + "FechaOrigen: "+ fechaOrigen + "FechaDestino: " + fechaDestino
    }
}