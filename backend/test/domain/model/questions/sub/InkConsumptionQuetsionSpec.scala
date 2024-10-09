package domain.model.questions.sub

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class InkConsumptionQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("inkConsumption", "expected"),
            (70, Yes),
            (69, No),
            (71, No),
        )

        forAll(examples) { (inkConsumption, expected) =>
            val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
            val question = new InkConsumptionQuestion(answerWeapon, inkConsumption, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("inkConsumption", "expected"),
            (70, Yes),
            (69, Yes),
            (71, No),
        )

        forAll(examples) { (inkConsumption, expected) =>
            val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
            val question = new InkConsumptionQuestion(answerWeapon, inkConsumption, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("inkConsumption", "expected"),
            (70, Yes),
            (69, No),
            (71, Yes),
        )

        forAll(examples) { (inkConsumption, expected) =>
            val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
            val question = new InkConsumptionQuestion(answerWeapon, inkConsumption, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}