package model

import java.util.logging.Filter

class Fantasy {

    var jugadores: ArrayList<Jugador>
    var participantes: ArrayList<Participante>
    var admins: ArrayList<Administrador>
    var puntuaciones: ArrayList<Jugador>
    var ganador: Participante? = null
    var puntos_ganador: Int = 0
    var portero: Int = 0
    var hayportero: Boolean?= null
    var defensa: Int = 0
    var haydefenesa: Boolean?= null
    var delantero: Int = 0
    var haydelantero: Boolean?= null
    var mediocentro: Int = 0
    var haymedio: Boolean?= null

    constructor(
        jugadores: ArrayList<Jugador>,
        puntuaciones: ArrayList<Jugador>,
        participantes: ArrayList<Participante>,
        admins: ArrayList<Administrador>
    ) {
        this.jugadores = jugadores
        this.puntuaciones = puntuaciones
        this.participantes = participantes
        this.admins = admins
    }

    fun validacionAdmin(persona: Persona) {

        if (persona is Administrador) {
            iniciarJuego()
        } else {
            println("Solo puede iniciar el juego un administrador.")
        }
    }

    fun iniciarJuego() {
        println("Juego empezado.")
        participantes.forEach { persona ->

            println("${persona.getNOMBRE()}: ${persona.getPuntos()} ptos.")
        }

    }

    fun ficharJugador(participante: Participante, id: Int) {
        jugadores.forEach { jugador: Jugador ->
            if (jugador.id == id && participante.presupuesto > jugador.valor!!) {
                participante.presupuesto = participante.presupuesto - jugador.valor!!
                participante.plantilla.forEach{jugador: Jugador ->
                    if (jugador.posicion.equals("Portero") && portero != 1){
                        hayportero
                    }
                    if (jugador.posicion.equals("Defensa") && defensa != 2){
                        haydefenesa
                    }
                    if (jugador.posicion.equals("Mediocentro") && mediocentro != 2){
                        haymedio
                    }
                    if (jugador.posicion.equals("Delantero") && delantero != 1){
                        haydelantero
                    }
                }
                if (hayportero == true){
                    participante.plantilla.add(jugador)
                    portero++
                    jugadores.remove(jugador)
                    println("Jugador añadido")
                }
                if (haydefenesa == true){
                    participante.plantilla.add(jugador)
                    defensa++
                    jugadores.remove(jugador)
                    println("Jugador añadido")
                }
                if (haymedio == true){
                    participante.plantilla.add(jugador)
                    mediocentro++
                    jugadores.remove(jugador)
                    println("Jugador añadido")
                }
                if (haydelantero == true){
                    participante.plantilla.add(jugador)
                    portero++
                    jugadores.remove(jugador)
                    println("Jugador añadido")
                }
            }
        }
    }

    fun validarEquipo(participante: Participante) {
        if (participante.plantilla.size < 6) {

            println("La plantilla del jugador ${participante}, no es valida.")

        }

    }

    fun listarJugadores(){
        jugadores.forEach{jugador ->
            if (jugador.valor!! >= 3000000){
                print(jugador.mostrarDatos())
            }
        }
    }

    fun mostrarGanador() {
        participantes.forEach { participante ->
            if (participante.getPuntos() > puntos_ganador) {
                ganador = participante
                puntos_ganador = participante.getPuntos()
            }
        }
        println("El ganador del juego es: ${ganador}")

    }


}