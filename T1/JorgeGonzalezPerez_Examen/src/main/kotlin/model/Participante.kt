package model

class Participante(id: Int, nombre: String) : Persona(id, nombre) {

    var plantilla: ArrayList<Jugador>
    var puntos: Int? = 0
    var presupuesto: Int = 10000000

    init {
        plantilla = ArrayList()
    }

    fun setPuntos(puntos: Int) {
        this.puntos = puntos;
    }

    fun getPuntos(): Int {
        return this.puntos!!;
    }

    fun setNOMBRE(nombre: String) {
        this.nombre = nombre;
    }

    fun getNOMBRE(): String {
        return this.nombre;
    }

    fun setPLANTILLa(plantilla: ArrayList<Jugador>) {
        this.plantilla = plantilla;
    }

    fun getPLANTILLA(): ArrayList<Jugador> {
        return this.plantilla;
    }

    fun setPRESUPUESTO(puntos: Int) {
        this.presupuesto = presupuesto;
    }

    fun getPRESUPUESTO(): Int {
        return this.presupuesto;
    }


}