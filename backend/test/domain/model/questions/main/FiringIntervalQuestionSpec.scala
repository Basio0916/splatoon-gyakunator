package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._

class FiringIntervalQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    val subWeapon = SubWeapon("sub weapon", 0, List(0.0), Yes, Yes, Yes, Yes)
    val specialWeapon = SpecialWeapon("special weapon", Yes, Yes, Yes, Yes, Yes, Yes, Yes)

    val splattershotJr = MainWeapon(
        name = "わかばシューター", 
        weaponCategory = WeaponCategory("シューター"),
        range = List(2.0),
        damage = List(28.0),
        firingInterval = List(5.0),
        spread = List(12.0),
        weight = Light,
        canRapidFire = Yes,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )
    val l3Nozzlenose = MainWeapon(
        name = "L3リールガン", 
        weaponCategory = WeaponCategory("シューター"),
        range = List(2.7),
        damage = List(29.0),
        firingInterval = List(4.0, 9.0),
        spread = List(1.0),
        weight = Middle,
        canRapidFire = No,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )

    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "firingInterval", "expected"),
            (splattershotJr, "5", Yes),
            (splattershotJr, "5.0", Yes),
            (splattershotJr, "5.1", No),
            (splattershotJr, "4.9", No),
            (l3Nozzlenose, "4", Partial),
            (l3Nozzlenose, "9", Partial),
            (l3Nozzlenose, "5", No),
        )

        forAll(examples) { (mainWeapon, firingInterval, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new FiringIntervalQuestion(answerWeapon, firingInterval, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "firingInterval", "expected"),
            (splattershotJr, "4.9", Yes),
            (splattershotJr, "5", Yes),
            (splattershotJr, "5.0", Yes),
            (splattershotJr, "5.1", No),
            (l3Nozzlenose, "3.9", Yes),
            (l3Nozzlenose, "4", Yes),
            (l3Nozzlenose, "4.0", Yes),
            (l3Nozzlenose, "4.1", Partial),
            (l3Nozzlenose, "9.0", Partial),
            (l3Nozzlenose, "9.1", No)
        )

        forAll(examples) { (mainWeapon, firingInterval, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new FiringIntervalQuestion(answerWeapon, firingInterval, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {

        val examples = Table(
            ("mainWeapon", "firingInterval", "expected"),
            (splattershotJr, "5.1", Yes),
            (splattershotJr, "5", Yes),
            (splattershotJr, "5.0", Yes),
            (splattershotJr, "4.9", No),
            (l3Nozzlenose, "9.1", Yes),
            (l3Nozzlenose, "9", Yes),
            (l3Nozzlenose, "9.0", Yes),
            (l3Nozzlenose, "8.9", Partial),
            (l3Nozzlenose, "4.0", Partial),
            (l3Nozzlenose, "3.9", No)
        )

        forAll(examples) { (mainWeapon, firingInterval, expected) =>
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new FiringIntervalQuestion(answerWeapon, firingInterval, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}