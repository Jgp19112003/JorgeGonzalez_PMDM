package model

class Jugador(id: Int,nombre: String) : Persona(id, nombre) {

    var puntuacion: Int? = null
    var posicion: String? = null
    var valor: Int? = null


    constructor(id: Int,nombre: String, posicion: String, valor: Int) : this(id, nombre) {
        this.posicion = posicion
        this.valor = valor
    }


    constructor(id: Int,nombre: String, puntuacion: Int) : this(id, nombre) {
        this.puntuacion = puntuacion
    }

    fun mostrarDatos(){
        println(id)
        println(nombre)
        println(posicion)
        println(valor)
    }


}