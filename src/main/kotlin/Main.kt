fun main() {
    val x = Fraction(2, 10)
    val y = 1.fr / 3
    val z = x / y

    println("$x / $y = $z")
    println("y is around ${y.toDouble()}")
    println("x == 1/5 = ${x == 1.fr / 5}")
    println("x < y = ${x < y}")
    println("-2/3 + 1/3 = ${Fraction(-2, 3) + Fraction(1, 3)}")
}