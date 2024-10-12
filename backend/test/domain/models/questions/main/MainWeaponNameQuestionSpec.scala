package domain.models.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class MainWeaponNameQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon's mainWeaponName is the same as mainWeaponName" in {

        val answerWeapon = Weapon("わかばシューター", splattershotJr, splatBomb, trizooka, 0)
        val question = new MainWeaponNameQuestion(answerWeapon, "わかばシューター")
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's mainWeaponName is not the same as mainWeaponName" in {

        val answerWeapon = Weapon("わかばシューター", splattershotJr, splatBomb, trizooka, 0)
        val question = new MainWeaponNameQuestion(answerWeapon, "スプラシューター")
        question.answer should be(No)
    }
}