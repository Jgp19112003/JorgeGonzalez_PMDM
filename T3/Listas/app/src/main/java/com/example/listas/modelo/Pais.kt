package com.example.spinner.modelo

 class Pais(var nombre: String, var imagen: Int, var numeroTitulos: Int, var estrella: String) {


    fun mostrarDetalles(){
        println("Numero de Titulos: " + numeroTitulos)
        println("Jugador estrella: " + estrella)
    }

     override fun toString(): String {
         return super.toString()
     }

}