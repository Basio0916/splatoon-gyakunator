package domain.models.questions.special

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class SpecialWeaponNameQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon's specialWeaponName is the same as specialWeaponName" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new SpecialWeaponNameQuestion(answerWeapon, "ウルトラショット")
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's specialWeaponName is not the same as specialWeaponName" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new SpecialWeaponNameQuestion(answerWeapon, "グレートバリア")
        question.answer should be(No)
    }
}