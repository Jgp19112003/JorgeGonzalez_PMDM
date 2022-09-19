fun main() {
    //funcionParametros("Borja",10);
    //funcionParametros(arg2 = 10,arg1 = "Borja");
    //funcionPorDefecto(numeroDos = 10, numeroTres = 20);
    funcionLambdaSuma(5,2)
}

fun funcionSimple(){
    println("Funcion simple ejecutada")

}
fun funcionParametros(arg1: String, arg2: Int){
    println("$arg1")
    println("$arg2")
}
fun funcionPorDefecto(numeroUno: Int =100, numeroDos: Int, numeroTres: Int){
    println("${numeroUno+numeroDos+numeroTres}")
}
fun funcionSuma(num1: Int, num2: Int) = println("${num1+num2}")
fun funcionRetorno():String {
    return "Borja";
}

var funcionLambdaSuma: (a:Int,b:Int) -> Unit = {arg1: Int, arg2: Int ->

    if (arg1 > 0 && arg2 > 0){
        println("${arg1 + arg2}")
    } else{
        println("Algunos de los numeros es negativo")
    }
}

