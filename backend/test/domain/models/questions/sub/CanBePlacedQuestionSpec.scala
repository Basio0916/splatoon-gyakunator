package domain.models.questions.sub

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class CanBePlacedQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return Yes when answerWeapon's subWeapon can be placed" in {

        val answerWeapon = Weapon("name", splattershotJr, squidBeakon, trizooka, 0)
        val question = new CanBePlacedQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's subWeapon cannot be placed" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new CanBePlacedQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's subWeapon can be placed partially" in {

        val answerWeapon = Weapon("name", splattershotJr, partiallySubWeapon, trizooka, 0)
        val question = new CanBePlacedQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}