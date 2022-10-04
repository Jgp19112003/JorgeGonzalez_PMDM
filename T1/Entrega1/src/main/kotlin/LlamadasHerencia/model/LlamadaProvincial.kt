package LlamadasHerencia.model

class LlamadaProvincial(nOrigen: String, nDestino: String, coste: Int, duracion: Int) : Llamada(nOrigen, nDestino, coste, duracion) {


    constructor(nOrigen: String, nDestino: String, franja: Int, coste: Int, duracion: Int) : this(nOrigen, nDestino, coste, duracion) {

        this.coste = 15;
    }

}