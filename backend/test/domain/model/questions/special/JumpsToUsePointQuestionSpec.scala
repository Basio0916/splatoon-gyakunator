package domain.model.questions.special

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class JumpsToUsePointQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return Yes when answerWeapon's specialWeapon jumpsToUsePoint is Yes" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, bigBubbler, 0)
        val question = new JumpsToUsePointQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's specialWeapon jumpsToUsePoint is No" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new JumpsToUsePointQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's specialWeapon jumpsToUsePoint is Partial" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, partiallySpecialWeapon, 0)
        val question = new JumpsToUsePointQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}