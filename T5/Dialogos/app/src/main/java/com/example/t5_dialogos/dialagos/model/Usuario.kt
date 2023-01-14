package com.example.t5_dialogos.dialagos.model

class Usuario(var nombre: String, var password: String, var recordar: Boolean) {

    override fun toString(): String {
        return "Nombre: "+nombre+"\n"+"Contraseña: "+password+"\n"+"¿Recordar Contraseña?: "+recordar
    }
}