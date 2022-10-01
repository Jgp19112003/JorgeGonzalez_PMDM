package LlamadasHerencia.model

open abstract class Llamada(protected var nOrigen: String, protected var nDestino: String, protected var coste: Int, protected var duracion: Int) {

    open fun mostrarDatos() {
        println("Origen: " + nOrigen)
        println("Destino: " + nDestino)
        println("Coste: " + coste)
        println("Duracion: " + duracion)
    }


    fun setCOSTE(coste: Int) {
        this.coste = coste;
    }

    fun getCOSTE(): Int {
        return this.coste;
    }

    fun setDURACION(duracion: Int) {
        this.duracion = duracion;
    }

    fun getDURACION(): Int {
        return this.duracion;
    }
}