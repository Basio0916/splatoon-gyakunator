package domain.models.questions.main

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class CanRollingOrBrushingQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon can rolling or brushing" in {

        val answerWeapon = Weapon("name", splatRoller, splatBomb, trizooka, 0)
        val question = new CanRollingOrBrushingQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon can not rolling or brushing" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanRollingOrBrushingQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon can rolling or brushing partially" in {

        val answerWeapon = Weapon("name", partiallyMainWeapon, splatBomb, trizooka, 0)
        val question = new CanRollingOrBrushingQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}