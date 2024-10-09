package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.main.MainWeaponSample._
import domain.model.questions.sub.SubWeaponSample._
import domain.model.questions.special.SpecialWeaponSample._

class SpreadQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "spread", "expected"),
            (splattershotJr, 12.0, Yes),
            (splattershotJr, 12.1, No),
            (splattershotJr, 11.9, No),
            (squeezer, 0.0, Partial),
            (squeezer, 8.0, Partial),
            (squeezer, 8.1, No),
        )

        forAll(examples) { (mainWeapon, spread, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new SpreadQuestion(answerWeapon, spread, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("mainWeapon", "spread", "expected"),
            (splattershotJr, 12.0, Yes),
            (splattershotJr, 12.1, No),
            (splattershotJr, 11.9, Yes),
            (squeezer, 0.0, Yes),
            (squeezer, 8.0, Partial),
            (squeezer, 8.1, No)
        )

        forAll(examples) { (mainWeapon, spread, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new SpreadQuestion(answerWeapon, spread, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("mainWeapon", "spread", "expected"),
            (splattershotJr, 12.0, Yes),
            (splattershotJr, 12.1, Yes),
            (splattershotJr, 11.9, No),
            (squeezer, 0.0, Partial),
            (squeezer, 8.0, Yes),
            (squeezer, -0.1, No)
        )

        forAll(examples) { (mainWeapon, spread, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new SpreadQuestion(answerWeapon, spread, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}