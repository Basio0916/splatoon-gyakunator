import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class AnswerSpec extends AnyFlatSpec with TableDrivenPropertyChecks {
    "Answer" should "override toString to display its class name" in {
        val examples = Table(
            ("Answer", "expectedResult"),
            (Yes, "Yes"),
            (No, "No"),
            (Partial, "Partial")
        )
        forAll(examples) { (answer, expectedResult) =>
            assert(answer.toString === expectedResult)
        }    
    }
}
