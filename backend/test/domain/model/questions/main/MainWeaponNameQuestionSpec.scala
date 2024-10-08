package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._

class MainWeaponNameQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    val subWeapon = SubWeapon("sub weapon", 0, (Some(0.0), Some(0.0), Some(0.0)), Yes, Yes, Yes, Yes)
    val specialWeapon = SpecialWeapon("special weapon", Yes, Yes, Yes, Yes, Yes, Yes, Yes)

    "MainWeaponNameQuestion" should "return Yes when answerWeapon's mainWeaponName is the same as mainWeaponName" in {
        val mainWeapon = MainWeapon(
            name = "わかばシューター", 
            weaponCategory = WeaponCategory("シューター"),
            range = (Some(1.6), None),
            damage = (Some(38.0), None, None, None),
            firingInterval = (Some(5.0), None),
            spread = (Some(12.0), None),
            weight = Light,
            canRapidFire = Yes,
            canCharge = No,
            isExplosive = No,
            canRollingOrBrushing = No,
            canChargeKeep = No,
            dodgeRollCount = 0,
            hasDirectHitSound = No
        )
        val answerWeapon = Weapon("わかばシューター", mainWeapon, subWeapon, specialWeapon, 0)
        val question = new MainWeaponNameQuestion(answerWeapon, "わかばシューター")
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's mainWeaponName is not the same as mainWeaponName" in {
        val mainWeapon = MainWeapon(
            name = "わかばシューター", 
            weaponCategory = WeaponCategory("シューター"),
            range = (Some(1.6), None),
            damage = (Some(38.0), None, None, None),
            firingInterval = (Some(5.0), None),
            spread = (Some(12.0), None),
            weight = Light,
            canRapidFire = Yes,
            canCharge = No,
            isExplosive = No,
            canRollingOrBrushing = No,
            canChargeKeep = No,
            dodgeRollCount = 0,
            hasDirectHitSound = No
        )
        val answerWeapon = Weapon("わかばシューター", mainWeapon, subWeapon, specialWeapon, 0)
        val question = new MainWeaponNameQuestion(answerWeapon, "スプラシューター")
        question.answer should be(No)
    }
}