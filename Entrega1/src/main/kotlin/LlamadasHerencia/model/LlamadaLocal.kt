package LlamadasHerencia.model

final class LlamadaLocal(nOrigen: String, nDestino: String, coste: Int, duracion: Int) : Llamada(nOrigen, nDestino, coste, duracion) {

    override fun mostrarDatos() {
        super.mostrarDatos()
    }

    constructor(nOrigen: String, nDestino: String, franja: Int, coste: Int, duracion: Int) : this(nOrigen, nDestino, coste, duracion) {

        this.coste = 0;
    }

}