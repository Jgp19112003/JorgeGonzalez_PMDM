package model.model

import model.Asalariado
import model.Autonomo
import model.Jefe
import model.Persona

class Empresa() {

    var trabajadores: ArrayList<Persona>?;
    var jefes: ArrayList<Jefe>?;
    var trabajador_despedido: Persona? = null


    init {
        trabajadores = ArrayList();
        jefes = ArrayList(1);
    }

    fun registrarTrabajador(persona: Persona) {

        trabajadores?.add(persona)

    }

    fun listarTrabajadores(opc: String) {

        trabajadores?.forEach { persona ->
            when (opc) {
                "jefes" -> {
                    if (persona is Jefe) {
                        persona.mostrarDatos()
                    }
                }
                "asalariados" -> {
                    if (persona is Asalariado) {
                        persona.mostrarDatos()
                    }

                }
                "autonomos" -> {
                    if (persona is Autonomo) {
                        persona.mostrarDatos()
                    }

                }
                else -> {
                    persona.mostrarDatos()
                }
            }

        }
    }

    fun mostrarDatosTrabajador(dni: String) {
        trabajadores?.forEach { persona ->
            if (dni.equals(persona.getDNI())) {
                persona.mostrarDatos()
            }
        }
    }

    fun comprobarDni(dni: String): Int {
        trabajadores?.forEach { persona ->
            if (dni.equals(persona.getDNI())) {
                println("Este DNI ya esta registrado.")
                return 1;
            }
        }
        return 0;
    }

    fun despedirTrabajador(dni: String) {
        trabajadores?.forEach { persona ->
            if (dni.equals(persona.getDNI()) && persona is Jefe) {
                var dni_empleado: String? = null
                println("Introduzca DNI del trabajador a despedir: ")
                dni_empleado = readLine()?.toString()
                trabajadores?.forEach { trabajador ->
                    if (dni_empleado == trabajador.getDNI()) {
                        trabajador_despedido = trabajador
                        println("Trabajador despedido")
                    } else {
                        println("El trabajador no existe.")

                    }
                }
            } else {
                println("Solo puede realizar un despido un trabajador.")
            }
        }
        trabajadores!!.remove(trabajador_despedido)
    }
}


