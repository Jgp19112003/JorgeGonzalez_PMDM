import kotlin.concurrent.thread

class Coche {

    var  marca: String
    var  modelo: String
    var  cv: Int
    var  bastidor: String? = null
    var  velocidad: Int? = 0

    constructor(marca: String, modelo: String, cv: Int){
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    fun acelerar(velocidad: Int){
        this.velocidad = this.velocidad?.plus(velocidad);
    }

    var decelerar: (Int) -> Boolean = {v -> if (this.velocidad!! - v < 0 ) false else true}


    fun frena(){
        for(i = velocidad in ){

        }
    }

}