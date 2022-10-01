package LlamadasHerencia

import LlamadasHerencia.model.Centralita
import LlamadasHerencia.model.LlamadaLocal
import LlamadasHerencia.model.LlamadaNacional
import LlamadasHerencia.model.LlamadaProvincial


fun main() {

    var centralita: Centralita = Centralita()
    var opc: Int? = 0;
    var nOrigen: String? = null;
    var nDestino: String? = null;
    var franja: Int? = null;
    var coste: Int? = null;
    var duracion: Int? = null;

    do {
        System.out.println("1. Registrar llamada");
        System.out.println("2. Mostrar costes");
        System.out.println("3. Mostrar llamada");
        opc = readLine()?.toInt()

        when (opc) {
            1 -> {
                println("1. Registrar llamada locales.")
                println("2. Registrar llamada provincial.")
                println("3. Registrar llamada nacional. ")
                opc = readLine()?.toInt()

                when (opc) {
                    1 -> {
                        println("Introduce origen: ")
                        nOrigen = readLine()?.toString()
                        println("Introduce destino: ")
                        nDestino = readLine()?.toString()
                        println("Introduce duracion (segundos): ")
                        duracion = readLine()?.toInt()
                        coste = 0
                        centralita.registrarLlamada(LlamadaLocal(nOrigen!!, nDestino!!, coste!!, duracion!!))
                        centralita.registrarCostes()
                    }
                    2 -> {
                        println("Introduce origen: ")
                        nOrigen = readLine()?.toString()
                        println("Introduce destino: ")
                        nDestino = readLine()?.toString()
                        println("Introduce duracion (segundos): ")
                        duracion = readLine()?.toInt()
                        coste = 15
                        centralita.registrarLlamada(LlamadaProvincial(nOrigen!!, nDestino!!, coste, duracion!!))
                        centralita.registrarCostes()

                    }
                    3 -> {
                        println("Introduce origen: ")
                        nOrigen = readLine()?.toString()
                        println("Introduce destino: ")
                        nDestino = readLine()?.toString()
                        println("Introduce franja: ")
                        franja = readLine()?.toInt()
                        println("Introduce duracion (segundos): ")
                        duracion = readLine()?.toInt()
                        centralita.registrarLlamada(LlamadaNacional(nOrigen!!, nDestino!!, franja!!, coste!!, duracion!!))
                        centralita.registrarCostes()

                    }
                }
            }
            2 -> {
                centralita.mostrarCostes()
            }
            3 -> {
                centralita.mostrarLlamadas()
            }
        }
    } while (opc != 0)

}//JP
