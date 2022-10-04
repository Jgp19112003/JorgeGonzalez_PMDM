import model.Administrador
import model.Fantasy
import model.Jugador
import model.Participante

fun main() {

    var fantasy = Fantasy(jugadores = ArrayList(), puntuaciones = ArrayList(), participantes = ArrayList(), admins = ArrayList())


    var a1: Administrador = (Administrador(5,"Borja",1))
    fantasy.admins.add(a1)

    var p1: Participante = (Participante(1,"Jorge",))
    fantasy.participantes.add(p1)
    var p2: Participante = (Participante(2,"Alex",))
    fantasy.participantes.add(p2)
    var p3: Participante = (Participante(3,"Zama",))
    fantasy.participantes.add(p3)
    var p4: Participante = (Participante(4,"Alvaro",))
    fantasy.participantes.add(p4)



    fantasy.jugadores.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
    fantasy.jugadores.add(Jugador(2,"Ronald Araújo", "Defensa",4000000))
    fantasy.jugadores.add(Jugador(3,"Eric García", "Defensa",1000000))
    fantasy.jugadores.add(Jugador(4,"Pedri", "Mediocentro",5000000))
    fantasy.jugadores.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000))
    fantasy.jugadores.add(Jugador(6,"Courtois", "Portero",3000000))
    fantasy.jugadores.add(Jugador(7,"David Alaba", "Defensa",4000000))
    fantasy.jugadores.add(Jugador(8,"Jesús Vallejo", "Defensa",500000))
    fantasy.jugadores.add(Jugador(9,"Luka Modric", "Mediocentro",5000000))
    fantasy.jugadores.add(Jugador(10,"Karim Benzema", "Delantero",8000000))
    fantasy.jugadores.add(Jugador(11,"Ledesma", "Portero",500000))
    fantasy.jugadores.add(Jugador(12,"Juan Cala", "Defensa",300000))
    fantasy.jugadores.add(Jugador(13,"Zaldua", "Defensa",400000))
    fantasy.jugadores.add(Jugador(14,"Alez Fernández", "Mediocentro",700000))
    fantasy.jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
    fantasy.jugadores.add(Jugador(16,"Rajković", "Portero",300000))
    fantasy.jugadores.add(Jugador(17,"Raíllo", "Defensa",200000))
    fantasy.jugadores.add(Jugador(18,"Maffeo", "Defensa",300000))
    fantasy.jugadores.add(Jugador(19,"Ruiz de Galarreta", "Mediocentro",400000))
    fantasy.jugadores.add(Jugador(20,"Remiro", "Portero",1000000))
    fantasy.jugadores.add(Jugador(21,"Elustondo", "Defensa",900000))
    fantasy.jugadores.add(Jugador(22,"Zubeldia", "Defensa",800000))
    fantasy.jugadores.add(Jugador(23,"Zubimendi", "Mediocentro",1000000))
    fantasy.jugadores.add(Jugador(24,"Take Kubo", "Delantero", 800000))
    fantasy.jugadores.add(Jugador(25,"Ángel", "Delantero", 300000))




    fantasy.puntuaciones.add(Jugador(1,"Marc-André ter Stegen", 10))
    fantasy.puntuaciones.add(Jugador(2,"Ronald Araújo",0))
    fantasy.puntuaciones.add(Jugador(3,"Eric García",3))
    fantasy.puntuaciones.add(Jugador(4,"Pedri",23))
    fantasy.puntuaciones.add(Jugador(5,"Robert Lewandowski",15))
    fantasy.puntuaciones.add(Jugador(6,"Courtois",1))
    fantasy.puntuaciones.add(Jugador(7,"David Alaba",5))
    fantasy.puntuaciones.add(Jugador(8,"Jesús Vallejo",10))
    fantasy.puntuaciones.add(Jugador(9,"Luka Modric",5))
    fantasy.puntuaciones.add(Jugador(10,"Karim Benzema",10))
    fantasy.puntuaciones.add(Jugador(11,"Ledesma",6))
    fantasy.puntuaciones.add(Jugador(12,"Juan Cala",3))
    fantasy.puntuaciones.add(Jugador(13,"Zaldua",6))
    fantasy.puntuaciones.add(Jugador(14,"Alez Fernández",9))
    fantasy.puntuaciones.add(Jugador(15, "Choco Lozano", 4))
    fantasy.puntuaciones.add(Jugador(16,"Rajković",3))
    fantasy.puntuaciones.add(Jugador(17,"Raíllo",6))
    fantasy.puntuaciones.add(Jugador(18,"Maffeo",0))
    fantasy.puntuaciones.add(Jugador(19,"Ruiz de Galarreta",7))
    fantasy.puntuaciones.add(Jugador(20,"Remiro",3))
    fantasy.puntuaciones.add(Jugador(21,"Elustondo",5))
    fantasy.puntuaciones.add(Jugador(22,"Zubeldia",6))
    fantasy.puntuaciones.add(Jugador(23,"Zubimendi",7))
    fantasy.puntuaciones.add(Jugador(24,"Take Kubo", 4))
    fantasy.puntuaciones.add(Jugador(25,"Ángel", 4))

    fantasy.validacionAdmin(a1)

    fantasy.ficharJugador(p1,1)
    fantasy.ficharJugador(p1,17)
    fantasy.ficharJugador(p1,18)
    fantasy.ficharJugador(p1,23)
    fantasy.ficharJugador(p1,14)
    fantasy.ficharJugador(p1,15)

    fantasy.ficharJugador(p2,11)
    fantasy.ficharJugador(p2,2)
    fantasy.ficharJugador(p2,3)
    fantasy.ficharJugador(p2,14)
    fantasy.ficharJugador(p2,23)
    fantasy.ficharJugador(p2,24)

    fantasy.ficharJugador(p3,11)
    fantasy.ficharJugador(p3,2)
    fantasy.ficharJugador(p3,3)
    fantasy.ficharJugador(p3,14)
    fantasy.ficharJugador(p3,23)
    fantasy.ficharJugador(p3,24)

    fantasy.ficharJugador(p4,6)
    fantasy.ficharJugador(p4,2)
    fantasy.ficharJugador(p4,18)
    fantasy.ficharJugador(p4,19)
    fantasy.ficharJugador(p4,23)


    fantasy.validarEquipo(p1)
    fantasy.validarEquipo(p2)
    fantasy.validarEquipo(p3)
    fantasy.validarEquipo(p4)

    fantasy.mostrarGanador()
    fantasy.listarJugadores()

}