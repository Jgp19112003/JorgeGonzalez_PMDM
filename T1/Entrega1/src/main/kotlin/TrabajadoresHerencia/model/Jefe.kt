package TrabajadoresHerencia.model

final class Jefe(nombre: String, apellido: String, dni: String, var acciones: Int = 0, var beneficio: Double = 0.0) : Persona(nombre, apellido, dni) {



    override fun mostrarDatos() {
        super.mostrarDatos()
        if (this.beneficio != 0.0)
            println("Beneficio: $beneficio")
        else println("No hay beneficios")
        if (this.acciones != 0)
            println("Acciones: $acciones")
        else println("No hay acciones")

    }

}