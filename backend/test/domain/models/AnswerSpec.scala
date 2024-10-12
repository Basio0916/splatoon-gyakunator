package domain.models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class AnswerSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    "Answer" should "override toString to display its class name" in {
        val examples = Table(
            ("Answer", "expectedResult"),
            (Yes, "Yes"),
            (No, "No"),
            (Partial, "Partial")
        )
        forAll(examples) { (answer, expectedResult) =>
            answer.toString should be(expectedResult)
        }
    }

    "apply" should "return Answer object from string" in {
        val examples = Table(
            ("value", "expectedResult"),
            ("yes", Yes),
            ("Yes", Yes),
            ("YES", Yes),
            ("no", No),
            ("No", No),
            ("NO", No),
            ("partial", Partial),
            ("Partial", Partial),
            ("PARTIAL", Partial)
        )
        forAll(examples) { (value, expectedResult) =>
            Answer(value) should be(expectedResult)
        }
    }

    it should "throw IllegalArgumentException when invalid value is given" in {
        val examples = Table(
            "value",
            "invalid"
        )
        forAll(examples) { value =>
            an[IllegalArgumentException] should be thrownBy {
                Answer(value)
            }
        }
    }
}