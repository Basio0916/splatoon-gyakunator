package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._

class SpreadQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
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
    val squeezer = MainWeapon(
        name = "ボトルガイザー", 
        weaponCategory = WeaponCategory("シューター"),
        range = List(3.3, 2.2),
        damage = List(38.0, 30.0),
        firingInterval = List(8.0, 7.0),
        spread = List(0.0, 8.0),
        weight = Middle,
        canRapidFire = Yes,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )

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
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
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
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
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
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new SpreadQuestion(answerWeapon, spread, LessThanOrEqual)
            question.answer should be(expected)
        }
    }
}