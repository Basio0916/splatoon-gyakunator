package domain.models.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class FiringIntervalQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "firingInterval", "expected"),
            (splattershotJr, 5.0, Yes),
            (splattershotJr, 5.1, No),
            (splattershotJr, 4.9, No),
            (l3Nozzlenose, 4.0, Partial),
            (l3Nozzlenose, 9.0, Partial),
            (l3Nozzlenose, 5.0, No),
        )

        forAll(examples) { (mainWeapon, firingInterval, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new FiringIntervalQuestion(answerWeapon, firingInterval, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "firingInterval", "expected"),
            (splattershotJr, 4.9, Yes),
            (splattershotJr, 5.0, Yes),
            (splattershotJr, 5.1, No),
            (l3Nozzlenose, 3.9, Yes),
            (l3Nozzlenose, 4.0, Yes),
            (l3Nozzlenose, 4.1, Partial),
            (l3Nozzlenose, 9.0, Partial),
            (l3Nozzlenose, 9.1, No)
        )

        forAll(examples) { (mainWeapon, firingInterval, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new FiringIntervalQuestion(answerWeapon, firingInterval, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "firingInterval", "expected"),
            (splattershotJr, 5.1, Yes),
            (splattershotJr, 5.0, Yes),
            (splattershotJr, 4.9, No),
            (l3Nozzlenose, 9.1, Yes),
            (l3Nozzlenose, 9.0, Yes),
            (l3Nozzlenose, 8.9, Partial),
            (l3Nozzlenose, 4.0, Partial),
            (l3Nozzlenose, 3.9, No)
        )

        forAll(examples) { (mainWeapon, firingInterval, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new FiringIntervalQuestion(answerWeapon, firingInterval, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}