package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._

class MainWeaponMaxDamageQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    val subWeapon = SubWeapon("sub weapon", 0, List(0.0), Yes, Yes, Yes, Yes)
    val specialWeapon = SpecialWeapon("special weapon", Yes, Yes, Yes, Yes, Yes, Yes, Yes)

    val mainWeapon = MainWeapon(
        name = "ノヴァブラスター", 
        weaponCategory = WeaponCategory("ブラスター"),
        range = List(1.6),
        damage = List(125.0, 70),
        firingInterval = List(40.0),
        spread = List(0.0),
        weight = Light,
        canRapidFire = Yes,
        canCharge = No,
        isExplosive = Yes,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = Yes
    )

    "answer" should "return correct Answer when Equal Comparator is given" in {

        val examples = Table(
            ("maxDamage", "expected"),
            (125.0, Yes),
            (125.1, No),
            (124.9, No),
            (70.0, No),
            (70.1, No),
        )

        forAll(examples) { (maxDamage, expected) =>
            val answerWeapon = Weapon("ノヴァブラスター", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new MainWeaponMaxDamageQuestion(answerWeapon, maxDamage, Equal)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when GreaterThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("maxDamage", "expected"),
            (125.0, Yes),
            (125.1, No),
            (124.9, Yes),
            (70.0, Yes),
            (70.1, Yes),
        )

        forAll(examples) { (maxDamage, expected) =>
            val answerWeapon = Weapon("ノヴァブラスター", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new MainWeaponMaxDamageQuestion(answerWeapon, maxDamage, GreaterThanOrEqual)
            question.answer should be(expected)
        }
    }

    it should "return correct Answer when LessThanOrEqual Comparator is given" in {
            
        val examples = Table(
            ("maxDamage", "expected"),
            (125.0, Yes),
            (125.1, Yes),
            (124.9, No),
            (70.0, No),
            (70.1, No),
        )

        forAll(examples) { (maxDamage, expected) =>
            val answerWeapon = Weapon("ノヴァブラスター", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new MainWeaponMaxDamageQuestion(answerWeapon, maxDamage, LessThanOrEqual)
            question.answer should be(expected)
        }
    }

}