package domain.model.questions

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import domain.model._
import domain.model.questions.main._
import domain.model.questions.sub._
import domain.model.questions.special._
import domain.model.questions.MainWeaponSample._
import domain.model.questions.SubWeaponSample._
import domain.model.questions.SpecialWeaponSample._

class QuestionSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "apply" should "return correct Question object" in {
            
        val examples = Table(
            ("questionName", "option", "comparator", "expected"),
            ("CanChargeKeepQuestion", None, None, classOf[CanChargeKeepQuestion]),
            ("CanChargeQuestion", None, None, classOf[CanChargeQuestion]),
            ("CanRapidFireQuestion", None, None, classOf[CanRapidFireQuestion]),
            ("CanRollingOrBrushingQuestion", None, None, classOf[CanRollingOrBrushingQuestion]),
            ("DodgeRollCountQuestion", Some("0"), Some("？"), classOf[DodgeRollCountQuestion]),
            ("FiringIntervalQuestion", Some("0"), Some("？"), classOf[FiringIntervalQuestion]),
            ("HasDirectHitSoundQuestion", None, None, classOf[HasDirectHitSoundQuestion]),
            ("IsExplosiveQuestion", None, None, classOf[IsExplosiveQuestion]),
            ("MainWeaponMaxDamageQuestion", Some("0"), Some("？"), classOf[MainWeaponMaxDamageQuestion]),
            ("MainWeaponNameQuestion", Some("わかばシューター？"), None, classOf[MainWeaponNameQuestion]),
            ("RangeQuestion", Some("0"), Some("？"), classOf[RangeQuestion]),
            ("SpreadQuestion", Some("0"), Some("？"), classOf[SpreadQuestion]),
            ("WeaponCategoryQuestion", Some("シューター？"), Some("？"), classOf[WeaponCategoryQuestion]),
            ("WeightQuestion", Some("最軽量級"), Some("？"), classOf[WeightQuestion]),
            ("CanBePlacedQuestion", None, None, classOf[CanBePlacedQuestion]),
            ("CanInkQuestion", None, None, classOf[CanInkQuestion]),
            ("CanMarkQuestion", None, None, classOf[CanMarkQuestion]),
            ("InkConsumptionQuestion", Some("0"), Some("？"), classOf[InkConsumptionQuestion]),
            ("SubWeaponIsAttackTypeQuestion", None, None, classOf[SubWeaponIsAttackTypeQuestion]),
            ("SubWeaponMaxDamageQuestion", Some("0"), Some("？"), classOf[SubWeaponMaxDamageQuestion]),
            ("SubWeaponNameQuestion", Some("スプラッシュボム？"), None, classOf[SubWeaponNameQuestion]),
            ("CanOneShotQuestion", None, None, classOf[CanOneShotQuestion]),
            ("DealsContinuousDamageQuestion", None, None, classOf[DealsContinuousDamageQuestion]),
            ("HasRButtonActionQuestion", None, None, classOf[HasRButtonActionQuestion]),
            ("HasZRButtonActionQuestion", None, None, classOf[HasZRButtonActionQuestion]),
            ("JumpsToUsePointQuestion", None, None, classOf[JumpsToUsePointQuestion]),
            ("SpecialWeaponIsAttackTypeQuestion", None, None, classOf[SpecialWeaponIsAttackTypeQuestion]),
            ("SpecialWeaponNameQuestion", Some("ウルトラショット"), None, classOf[SpecialWeaponNameQuestion]),
        )
        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        forAll(examples) { (questionName, option, comparator, expected) =>
            val question = Question.apply(questionName, answerWeapon, option, comparator)
            question shouldBe a[Question]
            question.getClass shouldEqual expected
        }
    }

    it should "throw IllegalArgumentException when questionName is invalid" in {
        val answerWeapon = Weapon("name", splattershotJr, splatBomb, trizooka, 0)
        assertThrows[IllegalArgumentException] {
            Question.apply("InvalidQuestion", answerWeapon, None, None)
        }
    }

    
}