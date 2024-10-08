import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class WeightSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "Weight" should "compare correctly using == operator" in {
        val examples = Table(
            ("Weight1", "Weight2", "expectedResult"),
            (ExtraLight, ExtraLight, true),
            (Light, Light, true),
            (Middle, Middle, true),
            (Heavy, Heavy, true),
            (ExtraLight, Light, false),
            (ExtraLight, Middle, false),
            (ExtraLight, Heavy, false),
            (Light, ExtraLight, false),
            (Light, Middle, false),
            (Light, Heavy, false),
            (Middle, ExtraLight, false),
            (Middle, Light, false),
            (Middle, Heavy, false),
            (Heavy, ExtraLight, false),
            (Heavy, Light, false),
            (Heavy, Middle, false)
        )
        forAll(examples) { (weight1, weight2, expectedResult) =>
            weight1 == weight2 should equal(expectedResult)
        }    
    }

    it should "compare correctly using < operator" in {
        val examples = Table(
            ("Weight1", "Weight2", "expectedResult"),
            (ExtraLight, ExtraLight, false),
            (Light, Light, false),
            (Middle, Middle, false),
            (Heavy, Heavy, false),
            (ExtraLight, Light, true),
            (ExtraLight, Middle, true),
            (ExtraLight, Heavy, true),
            (Light, ExtraLight, false),
            (Light, Middle, true),
            (Light, Heavy, true),
            (Middle, ExtraLight, false),
            (Middle, Light, false),
            (Middle, Heavy, true),
            (Heavy, ExtraLight, false),
            (Heavy, Light, false),
            (Heavy, Middle, false)
        )
        forAll(examples) { (weight1, weight2, expectedResult) =>
            weight1 < weight2 should equal(expectedResult)
        }    
    }

    it should "compare correctly using > operator" in {
        val examples = Table(
            ("Weight1", "Weight2", "expectedResult"),
            (ExtraLight, ExtraLight, false),
            (Light, Light, false),
            (Middle, Middle, false),
            (Heavy, Heavy, false),
            (ExtraLight, Light, false),
            (ExtraLight, Middle, false),
            (ExtraLight, Heavy, false),
            (Light, ExtraLight, true),
            (Light, Middle, false),
            (Light, Heavy, false),
            (Middle, ExtraLight, true),
            (Middle, Light, true),
            (Middle, Heavy, false),
            (Heavy, ExtraLight, true),
            (Heavy, Light, true),
            (Heavy, Middle, true)
        )
        forAll(examples) { (weight1, weight2, expectedResult) =>
            weight1 > weight2 should equal(expectedResult)
        }    
    }

    "from" should "return Weight object from value" in {
        val examples = Table(
            ("value", "expectedResult"),
            (0, ExtraLight),
            (1, Light),
            (2, Middle),
            (3, Heavy)
        )
        forAll(examples) { (value, expectedResult) =>
            Weight.from(value) should equal(expectedResult)
        }
    }

    it should "throw IllegalArgumentException when invalid value is given" in {
        val examples = Table(
            "value",
            -1,
            4
        )
        forAll(examples) { value =>
            an[IllegalArgumentException] should be thrownBy {
                Weight.from(value)
            }
        }
    }
}