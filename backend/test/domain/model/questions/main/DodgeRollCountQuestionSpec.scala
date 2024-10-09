package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class DodgeRollCountQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    "answer" should "return correct Answer when Equal Comparator is given" in {
        val examples = Table(
            ("mainWeapon", "dodgeRollCount", "expected"),
            (splatDualies, 2, Yes),
            (splatDualies, 3, No),
            (splattershotJr, 0, Yes)
        )

        forAll(examples) { (mainWeapon, dodgeRollCount, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new DodgeRollCountQuestion(answerWeapon, dodgeRollCount, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {
        val examples = Table(
            ("mainWeapon", "dodgeRollCount", "expected"),
            (splatDualies, 2, Yes),
            (splatDualies, 1, Yes),
            (splatDualies, 3, No),
        )

        forAll(examples) { (mainWeapon, dodgeRollCount, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new DodgeRollCountQuestion(answerWeapon, dodgeRollCount, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {
        val examples = Table(
            ("mainWeapon", "dodgeRollCount", "expected"),
            (splatDualies, 2, Yes),
            (splatDualies, 3, Yes),
            (splatDualies, 1, No),
        )

        forAll(examples) { (mainWeapon, dodgeRollCount, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new DodgeRollCountQuestion(answerWeapon, dodgeRollCount, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}