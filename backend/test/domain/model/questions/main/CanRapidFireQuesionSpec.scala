package domain.model.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.main.MainWeaponSample._
import domain.model.questions.sub.SubWeaponSample._
import domain.model.questions.special.SpecialWeaponSample._

class CanRapidFireQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon can rapid fire" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanRapidFireQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon can not rapid fire" in {

        val answerWeapon = Weapon("name", l3Nozzlenose, splatBomb, trizooka, 0)
        val question = new CanRapidFireQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon can rapid fire partially" in {

        val answerWeapon = Weapon("name", partiallyMainWeapon, splatBomb, trizooka, 0)
        val question = new CanRapidFireQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}