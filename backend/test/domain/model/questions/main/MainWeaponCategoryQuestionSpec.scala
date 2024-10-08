package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._

class MainWeaponCategoryQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    val subWeapon = SubWeapon("sub weapon", 0, (Some(0.0), Some(0.0), Some(0.0)), Yes, Yes, Yes, Yes)
    val specialWeapon = SpecialWeapon("special weapon", Yes, Yes, Yes, Yes, Yes, Yes, Yes)

    "MainWeaponCategoryQuestion" should "return Yes when answerWeapon's weaponCategory is the same as weaponCategory" in {
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
                "main weapon", 
                weaponCategory,
                (Some(0.0), Some(0.0)),
                (Some(0.0), Some(0.0), Some(0.0), Some(0.0)),
                (Some(0.0), Some(0.0)),
                (Some(0.0), Some(0.0)),
                Light,
                Yes,
                Yes,
                Yes,
                Yes,
                Yes,
                0,
                Yes
            )
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new MainWeaponCategoryQuestion(answerWeapon, weaponCategory)
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
                "main weapon", 
                weaponCategory1,
                (Some(0.0), Some(0.0)),
                (Some(0.0), Some(0.0), Some(0.0), Some(0.0)),
                (Some(0.0), Some(0.0)),
                (Some(0.0), Some(0.0)),
                Light,
                Yes,
                Yes,
                Yes,
                Yes,
                Yes,
                0,
                Yes
            )
            val answerWeapon = Weapon("name", mainWeapon, subWeapon, specialWeapon, 0)
            val question = new MainWeaponCategoryQuestion(answerWeapon, weaponCategory2)
            question.answer should be(No)
        }
    }
}