package domain.model.questions.special

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class DealsContinuousDamageQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon's specialWeapon deals continuous damage" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, inkStorm, 0)
        val question = new DealsContinuousDamageQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's specialWeapon does not deal continuous damage" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new DealsContinuousDamageQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's specialWeapon partially deals continuous damage" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, partiallySpecialWeapon, 0)
        val question = new DealsContinuousDamageQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}