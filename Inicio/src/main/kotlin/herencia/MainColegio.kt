package herencia

fun main() {
    var alumno: Alumno = Alumno("A1","Apellido1","1234A",20,"1234A")
    var alumno2: Alumno = Alumno("A2","Apellido2","1234A",17,"1234A")

    var profesor1: Profesor = Profesor("P1","Apellido3","12345E",20)
    var profesor2: Profesor = Profesor("P2","Apellido3","12345E",20, 3000)

    var listado= ArrayList<Persona>()
    listado.add(alumno)
    listado.add(alumno2)
    listado.add(profesor1)
    listado.add(profesor2)


    listado.forEach({it.mostrarDatos()})
}