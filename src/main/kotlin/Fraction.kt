class DenominatorCannotBeZeroException : Exception()

data class Fraction(
    val numerator: Int, val denominator: Int
) : Comparable<Fraction> {

    init {
        if (denominator == 0)
            throw DenominatorCannotBeZeroException()
    }

    private fun gcd(a: Int, b: Int): Int {
        TODO("реализация алгоритма Евклида")
    }

    private fun simplify(numerator: Int, denominator: Int): Fraction {

        val (n, d) = if (denominator < 0)
            Pair(-numerator, -denominator)
        else
            Pair(numerator, denominator)

        val x = gcd(if (n < 0) -n else n, d)
        return Fraction(n / x, d / x)
    }

    operator fun plus(rhs: Fraction): Fraction =
        simplify(
            this.numerator * rhs.denominator
                    + rhs.numerator * this.denominator,
            this.denominator * rhs.denominator
        )

    operator fun minus(rhs: Fraction): Fraction =
        simplify(
            this.numerator * rhs.denominator
                    - rhs.numerator * this.denominator,
            this.denominator * rhs.denominator
        )

    operator fun times(rhs: Fraction): Fraction =
        simplify(
            this.numerator * rhs.numerator,
            this.denominator * rhs.denominator
        )

    operator fun div(rhs: Fraction): Fraction =
        simplify(
            this.numerator * rhs.denominator,
            this.denominator * rhs.numerator
        )

    override fun compareTo(other: Fraction): Int =
        (this.numerator * other.denominator)
            .compareTo(other.numerator * this.denominator)

    override fun toString(): String {
        return "$numerator/$denominator"
    }
}

val Int.fr
    get() = Fraction(this, 1)

operator fun Fraction.div(rhs: Int): Fraction =
    Fraction(this.numerator, this.denominator * rhs)

fun Fraction.toDouble() =
    this.numerator.toDouble() / this.denominator