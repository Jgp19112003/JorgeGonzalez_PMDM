package LlamadasHerencia.model

class LlamadaNacional(nOrigen: String, nDestino: String, coste: Int, duracion: Int) : Llamada(nOrigen, nDestino, coste, duracion) {

    var franja: Int? = null

    override fun mostrarDatos() {
        super.mostrarDatos()
    }

    constructor(nOrigen: String, nDestino: String, franja: Int, coste: Int, duracion: Int) : this(nOrigen, nDestino, coste, duracion) {

        this.franja = franja;

        if (franja == 1) {
            this.coste = 20
        }
        if (franja == 2) {
            this.coste = 25
        }
        if (franja == 3) {
            this.coste = 30
        }

    }
}