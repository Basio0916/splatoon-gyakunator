package domain.model.questions.sub

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class CanInkQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return Yes when answerWeapon's subWeapon can ink" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanInkQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's subWeapon cannot ink" in {

        val answerWeapon = Weapon("name", splattershotJr, squidBeakon, trizooka, 0)
        val question = new CanInkQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's subWeapon can ink partially" in {

        val answerWeapon = Weapon("name", splattershotJr, partiallySubWeapon, trizooka, 0)
        val question = new CanInkQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}