package domain.models.questions.special

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class SpecialWeaponIsAttackTypeQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "answer" should "return Yes when answerWeapon's specialWeapon is AttackType" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new SpecialWeaponIsAttackTypeQuestion(answerWeapon)
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's specialWeapon is not AttackType" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, bigBubbler, 0)
        val question = new SpecialWeaponIsAttackTypeQuestion(answerWeapon)
        question.answer should be(No)
    }

    it should "return Partial when answerWeapon's specialWeapon is Partial AttackType" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, partiallySpecialWeapon, 0)
        val question = new SpecialWeaponIsAttackTypeQuestion(answerWeapon)
        question.answer should be(Partial)
    }
}