package domain.models.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class IsExplosiveQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon is explosive" in {

        val answerWeapon = Weapon("name", lunaBlaster, splatBomb, trizooka, 0)
        val question = new IsExplosiveQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon is not explosive" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new IsExplosiveQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon is explosive partially" in {

        val answerWeapon = Weapon("name", partiallyMainWeapon, splatBomb, trizooka, 0)
        val question = new IsExplosiveQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}