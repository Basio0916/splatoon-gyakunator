import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class ComparatorSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    "from" should "return Comparator object from string" in {
        val examples = Table(
            ("value", "expectedResult"),
            ("？", Equal),
            ("以下？", LessThanOrEqual),
            ("以上？", GreaterThanOrEqual)
        )
        forAll(examples) { (value, expectedResult) =>
            Comparator.from(value) should be(expectedResult)
        }
    }

    it should "throw IllegalArgumentException when invalid value is given" in {
        val examples = Table(
            "value",
            "invalid"
        )
        forAll(examples) { value =>
            an[IllegalArgumentException] should be thrownBy {
                Comparator.from(value)
            }
        }
    }

    "compare" should "return true when a is greater than or equal to b" in {
        val intExamples = Table(
            ("a", "b", "expectedResult"),
            (1, 1, true),
            (2, 1, true),
            (1, 2, false)
        )
        forAll(intExamples) { (a, b, expectedResult) =>
            GreaterThanOrEqual.compare(a, b) should be(expectedResult)
        }

        val doubleExamples = Table(
            ("a", "b", "expectedResult"),
            (1.0, 1.0, true),
            (2.0, 1.0, true),
            (1.0, 2.0, false)
        )
        forAll(doubleExamples) { (a, b, expectedResult) =>
            GreaterThanOrEqual.compare(a, b) should be(expectedResult)
        }

        val weightExamples = Table(
            ("a", "b", "expectedResult"),
            (ExtraLight, ExtraLight, true),
            (Light, ExtraLight, true),
            (ExtraLight, Light, false)
        )
        forAll(weightExamples) { (a, b, expectedResult) =>
            GreaterThanOrEqual.compare(a, b) should be(expectedResult)
        }
    }

    it should "return true when a is less than or equal to b" in {
        val intExamples = Table(
            ("a", "b", "expectedResult"),
            (1, 1, true),
            (1, 2, true),
            (2, 1, false)
        )
        forAll(intExamples) { (a, b, expectedResult) =>
            LessThanOrEqual.compare(a, b) should be(expectedResult)
        }

        val doubleExamples = Table(
            ("a", "b", "expectedResult"),
            (1.0, 1.0, true),
            (1.0, 2.0, true),
            (2.0, 1.0, false)
        )
        forAll(doubleExamples) { (a, b, expectedResult) =>
            LessThanOrEqual.compare(a, b) should be(expectedResult)
        }

        val weightExamples = Table(
            ("a", "b", "expectedResult"),
            (ExtraLight, ExtraLight, true),
            (ExtraLight, Light, true),
            (Light, ExtraLight, false)
        )
        forAll(weightExamples) { (a, b, expectedResult) =>
            LessThanOrEqual.compare(a, b) should be(expectedResult)
        }
    }

    it should "return true when a is equal to b" in {
        val intExamples = Table(
            ("a", "b", "expectedResult"),
            (1, 1, true),
            (1, 2, false),
            (2, 1, false)
        )
        forAll(intExamples) { (a, b, expectedResult) =>
            Equal.compare(a, b) should be(expectedResult)
        }

        val doubleExamples = Table(
            ("a", "b", "expectedResult"),
            (1.0, 1.0, true),
            (1.0, 2.0, false),
            (2.0, 1.0, false)
        )
        forAll(doubleExamples) { (a, b, expectedResult) =>
            Equal.compare(a, b) should be(expectedResult)
        }

        val weightExamples = Table(
            ("a", "b", "expectedResult"),
            (ExtraLight, ExtraLight, true),
            (ExtraLight, Light, false),
            (Light, ExtraLight, false)
        )
        forAll(weightExamples) { (a, b, expectedResult) =>
            Equal.compare(a, b) should be(expectedResult)
        }
    }
}