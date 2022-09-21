fun main() {
    var coche1: Coche = Coche("Mercedes", "C220", 100)
    coche1.asignarPropietarios(Propietario("B", "M", "123"))
    println(coche1.propietario)
}