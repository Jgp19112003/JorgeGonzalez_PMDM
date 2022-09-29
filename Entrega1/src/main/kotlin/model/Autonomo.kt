package model

class Autonomo (nombre: String, apellido: String, dni: String, var salario: Int = 0) : Persona(nombre, apellido, dni) {

    var contratado: Boolean = false;

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario anual: $salario")
    }


}