package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class RangeQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "range", "expected"),
            (splattershotJr, 2.0, Yes),
            (splattershotJr, 2.1, No),
            (splattershotJr, 1.9, No),
            (squeezer, 3.3, Partial),
            (squeezer, 2.2, Partial),
            (squeezer, 3.2, No),
        )

        forAll(examples) { (mainWeapon, range, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new RangeQuestion(answerWeapon, range, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("mainWeapon", "range", "expected"),
            (splattershotJr, 2.0, Yes),
            (splattershotJr, 2.1, No),
            (splattershotJr, 1.9, Yes),
            (squeezer, 3.3, Partial),
            (squeezer, 2.2, Yes),
            (squeezer, 3.4, No)
        )

        forAll(examples) { (mainWeapon, range, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new RangeQuestion(answerWeapon, range, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("mainWeapon", "range", "expected"),
            (splattershotJr, 2.0, Yes),
            (splattershotJr, 2.1, Yes),
            (splattershotJr, 1.9, No),
            (squeezer, 3.3, Yes),
            (squeezer, 2.2, Partial),
            (squeezer, 2.1, No)
        )

        forAll(examples) { (mainWeapon, range, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new RangeQuestion(answerWeapon, range, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}