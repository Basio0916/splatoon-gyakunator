package domain.models.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class HasDirectHitSoundQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon has directHitSound" in {

        val answerWeapon = Weapon("name", splatCharger, splatBomb, trizooka, 0)
        val question = new HasDirectHitSoundQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon does not have directHitSound" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new HasDirectHitSoundQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon has directHitSound partially" in {

        val answerWeapon = Weapon("name", partiallyMainWeapon, splatBomb, trizooka, 0)
        val question = new HasDirectHitSoundQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}