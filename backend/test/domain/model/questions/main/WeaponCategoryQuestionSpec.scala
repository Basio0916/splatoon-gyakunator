package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._

class WeaponCategoryQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    val subWeapon = SubWeapon("sub weapon", 0, List(0.0), Yes, Yes, Yes, Yes)
    val specialWeapon = SpecialWeapon("special weapon", Yes, Yes, Yes, Yes, Yes, Yes, Yes)

    "answer" should "return Yes when answerWeapon's weaponCategory is the same as weaponCategory" in {
        val examples = Table(
            ("weaponCategory"),
            (WeaponCategory("シューター")),
            (WeaponCategory("チャージャー")),
            (WeaponCategory("スロッシャー")),
            (WeaponCategory("スピナー")),
            (WeaponCategory("ローラー")),
            (WeaponCategory("フデ")),
            (WeaponCategory("ブラスター")),
            (WeaponCategory("マニューバー")),
            (WeaponCategory("シェルター")),
            (WeaponCategory("ストリンガー")),
            (WeaponCategory("ワイパー")),
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
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new WeaponCategoryQuestion(answerWeapon, weaponCategory)
            question.answer should be(Yes)
        }
    }

    it should "return No when answerWeapon's weaponCategory is not the same as weaponCategory" in {
        val examples = Table(
            ("weaponCategory1", "weaponCategory2"),
            (WeaponCategory("シューター"), WeaponCategory("ローラー")),
            (WeaponCategory("ローラー"), WeaponCategory("シューター")),
            (WeaponCategory("ローラー"), WeaponCategory("チャージャー")),
            (WeaponCategory("シューター"), WeaponCategory("チャージャー")),
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
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new WeaponCategoryQuestion(answerWeapon, weaponCategory2)
            question.answer should be(No)
        }
    }
}