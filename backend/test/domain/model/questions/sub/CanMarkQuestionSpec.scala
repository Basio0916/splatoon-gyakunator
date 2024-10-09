package domain.model.questions.sub

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class CanMarkQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return Yes when answerWeapon's subWeapon can mark" in {

        val answerWeapon = Weapon("name", splattershotJr, pointSensor, trizooka, 0)
        val question = new CanMarkQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's subWeapon cannot mark" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanMarkQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's subWeapon can mark partially" in {

        val answerWeapon = Weapon("name", splattershotJr, partiallySubWeapon, trizooka, 0)
        val question = new CanMarkQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}