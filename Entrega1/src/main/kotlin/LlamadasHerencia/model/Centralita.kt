package LlamadasHerencia.model

class Centralita {

    var costes_totales: Int? = 0
    var costes_llamada: Int? = null
    var llamadas: ArrayList<Llamada>?;


    init {
        llamadas = ArrayList();
    }

    fun registrarLlamada(llamada: Llamada) {
        llamadas?.add(llamada)
    }

    fun mostrarLlamadas() {
        llamadas?.forEach { llamada ->
            llamada.mostrarDatos()
        }
    }

    fun mostrarCostes() {
        println(costes_totales)
    }

    fun registrarCostes() {
        llamadas?.forEach { llamada ->
            costes_llamada = (llamada.getCOSTE() * llamada.getDURACION())
        }
        costes_totales = costes_totales?.plus(costes_llamada!!)

    }

}
