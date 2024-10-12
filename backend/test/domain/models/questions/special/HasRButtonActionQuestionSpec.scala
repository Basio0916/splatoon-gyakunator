package domain.models.questions.special

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class HasRButtonActionQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon's specialWeapon has R button Action" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, crabTank, 0)
        val question = new HasRButtonActionQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's specialWeapon does not have R button Action" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new HasRButtonActionQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's specialWeapon has Partial R button Action" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, partiallySpecialWeapon, 0)
        val question = new HasRButtonActionQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}