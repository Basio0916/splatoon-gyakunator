package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.main.MainWeaponSample._
import domain.model.questions.sub.SubWeaponSample._
import domain.model.questions.special.SpecialWeaponSample._

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