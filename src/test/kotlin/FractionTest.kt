import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FractionTest : FunSpec({
    test("dummy case 1") {
        Fraction(1, 1).numerator shouldBe 2
    }
})