class Trabajador (var nombre: String, var apellido: String, val dni: String){


    var acciones: Int? = 0
        set(acciones) {
            field = acciones;
        }
        get() = field
    var beneficio: Int? = 0
        set(beneficio) {
            field = beneficio;
        }
        get() = field

    var sueldo: Int? = 0
        set(sueldo) {
            field = sueldo;
        }
        get() = field
    var num_pagas: Int? = 0
        set(num_pagas) {
            field = num_pagas;
        }
        get() = field
    var contratado: Boolean? = false
        set(contratado) {
            field = contratado;
        }
        get() = field

    constructor(nombre: String, apellido: String, dni: String, acciones: Int, beneficio: Int) : this(nombre, apellido, dni) {
        this.acciones = acciones
        this.beneficio = beneficio
    }

    constructor(nombre: String, apellido: String, dni: String, sueldo: Int, num_pagas: Int, contratado: Boolean) : this(nombre, apellido, dni) {
        this.sueldo = sueldo
        this.num_pagas = num_pagas
        this.contratado = contratado
    }
    constructor(nombre: String, apellido: String, dni: String, sueldo: Int,  contratado: Boolean) : this(nombre, apellido, dni) {
        this.sueldo = sueldo
        this.contratado = contratado
    }


}