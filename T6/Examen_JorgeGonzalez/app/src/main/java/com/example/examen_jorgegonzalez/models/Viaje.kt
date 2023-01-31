package com.example.examen_jorgegonzalez.models

class Viaje (var ciudad: Ciudad, var fechaOrigen: String,var fechaDestino: String) {
    override fun toString(): String {
        return "Nombre: "+ ciudad.nombre + "FechaOrigen: "+ fechaOrigen + "FechaDestino: " + fechaDestino
    }
}