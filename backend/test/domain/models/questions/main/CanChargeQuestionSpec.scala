package domain.models.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class CanChargeQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon can charge" in {

        val answerWeapon = Weapon("name", splatCharger, splatBomb, trizooka, 0)
        val question = new CanChargeQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon can not charge" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanChargeQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon can charge partially" in {

        val answerWeapon = Weapon("name", partiallyMainWeapon, splatBomb, trizooka, 0)
        val question = new CanChargeQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}