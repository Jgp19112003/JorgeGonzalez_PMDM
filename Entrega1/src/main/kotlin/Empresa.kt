import kotlin.reflect.typeOf

class Empresa {

    var trabajadores =  ArrayList<Trabajador>()

    fun registrarTrabajdor(trabajador: Trabajador){

    }

    fun pedirDatos (){
        var tipo : Int
        var nombre: String
        var apellido: String
        val dni: String
        var acciones: Int
        var beneficio: Int
        var num_pagas: Int
        var contratado: Boolean
        println("1. Jefe 2. Adalariado 3. Autonomo")
        tipo = readln().toInt()
        println("Introduzca nombre: ")
        nombre = readln()
        println("Introduzca apellido: ")
        apellido = readln()
        println("Introduzca DNI: ")
        dni = readln()


    }
}