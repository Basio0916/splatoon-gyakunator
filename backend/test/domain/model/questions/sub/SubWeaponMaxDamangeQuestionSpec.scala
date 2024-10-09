package domain.model.questions.sub

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class SubWeaponMaxDamageQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("maxDamage", "expected"),
            (180.0, Yes),
            (180.1, No),
            (179.9, No),
            (30.0, No)
        )

        forAll(examples) { (maxDamage, expected) =>
            val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
            val question = new SubWeaponMaxDamageQuestion(answerWeapon, maxDamage, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("maxDamage", "expected"),
            (180.0, Yes),
            (180.1, No),
            (179.9, Yes),
            (30.0, Yes)
        )

        forAll(examples) { (maxDamage, expected) =>
            val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
            val question = new SubWeaponMaxDamageQuestion(answerWeapon, maxDamage, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("maxDamage", "expected"),
            (180.0, Yes),
            (180.1, Yes),
            (179.9, No),
            (30.0, No)
        )

        forAll(examples) { (maxDamage, expected) =>
            val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
            val question = new SubWeaponMaxDamageQuestion(answerWeapon, maxDamage, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}