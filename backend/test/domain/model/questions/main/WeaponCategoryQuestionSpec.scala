package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.sub.SubWeaponSample._
import domain.model.questions.special.SpecialWeaponSample._

class WeaponCategoryQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return Yes when answerWeapon's weaponCategory is the same as weaponCategory" in {
        val examples = Table(
            ("weaponCategory"),
            (Shooter),
            (Roller),
            (Charger),
            (Blaster),
            (Slosher),
            (Splatling),
            (Brella),
            (Dualies),
            (Brush),
            (Stringer),
            (Splatana)
        )
        forAll(examples) { (weaponCategory) =>
            val mainWeapon = MainWeapon(
                name = "ブキ", 
                weaponCategory = weaponCategory,
                range = List(0.0),
                damage = List(0.0),
                firingInterval = List(0.0),
                spread = List(0.0),
                weight = Light,
                canRapidFire = Yes,
                canCharge = No,
                isExplosive = No,
                canRollingOrBrushing = No,
                canChargeKeep = No,
                dodgeRollCount = 0,
                hasDirectHitSound = No
            )
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new WeaponCategoryQuestion(answerWeapon, weaponCategory)
            question.answer should be(Yes)
        }
    }

    it should "return No when answerWeapon's weaponCategory is not the same as weaponCategory" in {
        val examples = Table(
            ("weaponCategory1", "weaponCategory2"),
            (Shooter, Roller),
            (Roller, Shooter),
            (Roller, Charger),
            (Shooter, Charger),
        )
        forAll(examples) { (weaponCategory1, weaponCategory2) =>
            val mainWeapon = MainWeapon(
                name = "ブキ", 
                weaponCategory = weaponCategory1,
                range = List(0.0),
                damage = List(0.0),
                firingInterval = List(0.0),
                spread = List(0.0),
                weight = Light,
                canRapidFire = Yes,
                canCharge = No,
                isExplosive = No,
                canRollingOrBrushing = No,
                canChargeKeep = No,
                dodgeRollCount = 0,
                hasDirectHitSound = No
            )
            val answerWeapon = Weapon("name", mainWeapon, splatBomb, trizooka, 0)
            val question = new WeaponCategoryQuestion(answerWeapon, weaponCategory2)
            question.answer should be(No)
        }
    }
}