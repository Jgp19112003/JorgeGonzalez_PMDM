package com.example.menus.model

class Asignatura (var siglas: String, var nombre: String, var nombreProfesor: String, var horas: String, var ciclo: String, var curso: String){
    override fun toString(): String {
        return siglas
    }
}