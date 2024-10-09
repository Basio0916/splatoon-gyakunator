package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.main.MainWeaponSample._
import domain.model.questions.sub.SubWeaponSample._
import domain.model.questions.special.SpecialWeaponSample._

class CanChargeKeepQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon can charge keep" in {

        val answerWeapon = Weapon("name", splatCharger, splatBomb, trizooka, 0)
        val question = new CanChargeKeepQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon can not charge keep" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanChargeKeepQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon can charge keep partially" in {

        val answerWeapon = Weapon("name", partiallyMainWeapon, splatBomb, trizooka, 0)
        val question = new CanChargeKeepQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}