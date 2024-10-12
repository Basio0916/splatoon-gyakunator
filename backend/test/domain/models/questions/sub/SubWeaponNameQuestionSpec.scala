package domain.models.questions.sub

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.models._
import domain.models.questions.MainWeaponSample._
import domain.models.questions.SubWeaponSample._
import domain.models.questions.SpecialWeaponSample._

class SubWeaponNameQuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    
    "answer" should "return Yes when answerWeapon's subWeaponName is the same as subWeaponName" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new SubWeaponNameQuestion(answerWeapon, "スプラッシュボム")
        question.answer should be(Yes)
    }

    it should "return No when answerWeapon's subWeaponName is not the same as subWeaponName" in {

        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        val question = new SubWeaponNameQuestion(answerWeapon, "キューバンボム")
        question.answer should be(No)
    }
}