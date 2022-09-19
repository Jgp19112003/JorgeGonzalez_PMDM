// VARIABLES - FUNCIONES - CLASE

// FUNCIONES fun nombre(arg: Tipo){
// }

// FUNCIONES fun nombre(arg: Tipo): Tipo retorno{
// return
// }

fun main(arg: Array<String>){

    //tipo nombre: Tipo = valor
    //var (normal) val(constante)
    //lateinit

    /*var nombre: String? = null
    var edad: Int = 18
    var aficiones: Array<String>;
    val DNI = "123456789A"
    nombre = readLine();

    println("Primera ejecucion de Kotlin")
    println("Hola soy ${nombre} y tengo ${edad} años")*/


// fun nombre (parametros): tipo retorno --> Unit es el void de java
fun etructuraIf() {
    println("Estructura de control If")
    // id (c) {} else {}
    // id (c) {} else if (c) {} else {}
    var nombre: String? = null
    println("Introduce tu nombre")
    nombre = readLine();


    // evaluar si la longuitud del nombre es mas grnade que 5
    // en ese caso sacar por consola un nombre demasiado grade
    // en caso contrario sacar por consola nombre correcto

    if (nombre?.length!! > 5){
        println("Nombre demsaiado largo")
    }else{
        println("Nombre correcto")
    }

}
fun etructuraFor() {
    // for (i=0;i<10;i++){}
    // for (i in 1..10){}
    for (i in 1..50 step 2){
        //println(i)
        //(int) (Math.rancom() * 51)
        var aleatorio = (1..50).random()
        println(aleatorio)
    }
}

    var suma: Int = 0
    var media: Double = 0.0
    var max: Int = 0
    var min: Int = 999999
    var edad  = 0

    println("Introduce edad")
    edad = readLine()!!.toInt()
    if (edad > 18){
        println("Edad correcta")
    for (i in 1..10){
        //println(i)
        //(int) (Math.rancom() * 51)
        var aleatorio = (1..100).random()
        println(aleatorio)
        suma += aleatorio
        media =  suma.toDouble()/10

        if (aleatorio > max){
            max = aleatorio
        }
        if (aleatorio < min) {
            min = aleatorio
        }

    }
        println("La suma es: ${suma}")
        println("La media es: ${media}")
        println("El numero maximo es: ${max}")
        println("El numero minimo es: ${min}")
    } else{
        println("Edad incorrecta")
    }

    // froeach
    (1..10).forEach({item ->
        println("Ejecucion del foreach")
        println(item) })

    fun estrcturaWhen(){
        // when dato{
        // valor -> {ejecuta}
        // valor -> {ejecuta}
        // valor -> {ejecuta}
        // default -> {ejecuta}
        // }

        println("Porfavor introdice la nota del examen")
        var nota = readLine()!!.toInt()
        when(nota){
            1->{
                println("Examen nulo")
            }5->{
                println("Examen justo")
            }10->{
                println("Examen perfecto")
            }
        }
    }

    var arrayPalabras: Array<String?> = arrayOfNulls<String>(5)
    arrayPalabras[0] = "Hola"
    arrayPalabras[1] = "que"
    arrayPalabras[2] = "tal"
    arrayPalabras[3] = "estas"
    arrayPalabras[4] = "tu"


    arrayPalabras.forEachIndexed({index, value ->
        if (index %2 == 0) {
            println("${value}")
        }
    })

    arrayPalabras.forEach { item ->
        if (item?.length!! >= 5){
            println(item)
        }
    }

  //  arrayPalabras.filter ({ elemento : String? -> })

    var listaAlumnosKt = ArrayList<String>()
    listaAlumnosKt.add("Jorge")
    listaAlumnosKt.add("Hunter")
    listaAlumnosKt.add("Alex")
    listaAlumnosKt.add("Zama")

    listaAlumnosKt.forEach({ println(it) })

    fun funcionParametro(arg1: String, arg2: Int){
        println("$arg1")
        println("$arg2")
    }

}


