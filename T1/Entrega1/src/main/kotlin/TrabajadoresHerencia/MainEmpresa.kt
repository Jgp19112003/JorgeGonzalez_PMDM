import TrabajadoresHerencia.model.Asalariado
import TrabajadoresHerencia.model.Autonomo
import TrabajadoresHerencia.model.Jefe
import TrabajadoresHerencia.model.model.Empresa

fun main() {


    var empresa: Empresa = Empresa();
    var opc: Int? = 0;
    var nombre: String? = null;
    var apellido: String? = null;
    var dni: String? = null;
    var salario: Int? = null;
    var numeroPagas: Int? = null;
    var beneficio: Double? = null;
    var acciones: Int? = null;
    var hayjefe: Boolean? = null;
    do {
        println("1. Registrar un trabajador.")
        println("2. Listar trabajadores.")
        println("3. Mostrar datos de trabajador. ")
        println("4. Despedir trabajador.")
        opc = readLine()?.toInt()


        when (opc) {
            1 -> {
                var opc2: Int? = 0;
                println("1. Asalariado")
                println("2. Autonomo")
                println("3. Jefe")
                opc2 = readLine()?.toInt()

                when (opc2){
                    1 -> {
                        println("Introuzca nombre: ")
                        nombre = readLine()?.toString()
                        println("Introuzca apellido: ")
                        apellido = readLine()?.toString()
                        println("Introuzca DNI: ")
                        dni = readLine()?.toString()
                        if (empresa.comprobarDni(dni!!) == 0){
                        println("Introuzca salario anual: ")
                        salario = readLine()?.toInt()
                        println("Introuzca numero de pagas: ")
                        numeroPagas = readLine()?.toInt()
                        empresa.registrarTrabajador(Asalariado(nombre!!, apellido!!, dni, salario!!, numeroPagas!!))
                        }
                    }
                    2 -> {
                        println("Introuzca nombre: ")
                        nombre = readLine()?.toString()
                        println("Introuzca apellido: ")
                        apellido = readLine()?.toString()
                        println("Introuzca DNI: ")
                        dni = readLine()?.toString()
                        if (empresa.comprobarDni(dni!!) == 0){
                        println("Introuzca salario anual: ")
                        salario = readLine()?.toInt()
                        empresa.registrarTrabajador(Autonomo(nombre!!, apellido!!, dni, salario!!))
                        }
                    }
                    3 -> {
                        if (empresa.jefes?.size == 1){
                            println("Ya hay un jefe en esta empresa.-")
                        }else {

                        println("Introuzca nombre: ")
                        nombre = readLine()?.toString()
                        println("Introuzca apellido: ")
                        apellido = readLine()?.toString()
                        println("Introuzca DNI: ")
                        dni = readLine()?.toString()
                        if (empresa.comprobarDni(dni!!) == 0){
                        println("Introuzca acciones: ")
                        acciones = readLine()?.toInt()
                        println("Introuzca beneficio: ")
                        beneficio = readLine()?.toDouble()
                        empresa.registrarTrabajador(Jefe(nombre!!, apellido!!, dni, acciones!!, beneficio!!))
                        empresa.jefes?.add(Jefe(nombre, apellido, dni, acciones, beneficio))
                        }

                        }
                    }
                }
            }

            2 -> {
                var opc: String? = null;
                println("¿Que quiere listar?")
                opc = readLine()?.toString()
                empresa.listarTrabajadores(opc!!)
            }

            3 -> {
                println("Introduzca DNI: ")
                dni = readLine()?.toString()
                empresa.mostrarDatosTrabajador(dni!!)
            }

            4 -> {
                println("Introduzca su DNI: ")
                dni = readLine()?.toString()
                empresa.despedirTrabajador(dni!!)
            }


        }


    } while (opc != 0)
}//JP

fun readLine(beneficio: Double) {
    TODO("Not yet implemented")
}

fun readLine(nombre: String) {
    TODO("Not yet implemented")
}


fun readLine(opc: Int?) {
    TODO("Not yet implemented")
}
