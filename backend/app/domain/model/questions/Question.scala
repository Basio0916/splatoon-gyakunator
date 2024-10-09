package domain.model.questions

import domain.model._
import domain.model.questions.main._
import domain.model.questions.special._
import domain.model.questions.sub._

trait Question{
    def answer: Answer
}

object Question {
    def apply(questionName: String, answerWeapon: Weapon, option: Option[String], comparator: Option[String]): Question = questionName match {
        case "CanChargeKeepQuestion" => new CanChargeKeepQuestion(answerWeapon)
        case "CanChargeQuestion" => new CanChargeQuestion(answerWeapon)
        case "CanRapidFireQuestion" => new CanRapidFireQuestion(answerWeapon)
        case "CanRollingOrBrushingQuestion" => new CanRollingOrBrushingQuestion(answerWeapon)
        case "DodgeRollCountQuestion" => new DodgeRollCountQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "FiringIntervalQuestion" => new FiringIntervalQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "HasDirectHitSoundQuestion" => new HasDirectHitSoundQuestion(answerWeapon)
        case "IsExplosiveQuestion" => new IsExplosiveQuestion(answerWeapon)
        case "MainWeaponMaxDamageQuestion" => new MainWeaponMaxDamageQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "MainWeaponNameQuestion" => new MainWeaponNameQuestion(answerWeapon, option.get.dropRight(1))
        case "RangeQuestion" => new RangeQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "SpreadQuestion" => new SpreadQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "WeaponCategoryQuestion" => new WeaponCategoryQuestion(answerWeapon, WeaponCategory(option.get.dropRight(1)))
        case "WeightQuestion" => new WeightQuestion(answerWeapon, Weight(option.get), Comparator(comparator.get))

        case "CanBePlacedQuestion" => new CanBePlacedQuestion(answerWeapon)
        case "CanInkQuestion" => new CanInkQuestion(answerWeapon)
        case "CanMarkQuestion" => new CanMarkQuestion(answerWeapon)
        case "InkConsumptionQuestion" => new InkConsumptionQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "SubWeaponIsAttackTypeQuestion" => new SubWeaponIsAttackTypeQuestion(answerWeapon)
        case "SubWeaponMaxDamageQuestion" => new SubWeaponMaxDamageQuestion(answerWeapon, option.get.toDouble, Comparator(comparator.get))
        case "SubWeaponNameQuestion" => new SubWeaponNameQuestion(answerWeapon, option.get.dropRight(1))
        
        case "CanOneShotQuestion" => new CanOneShotQuestion(answerWeapon)
        case "DealsContinuousDamageQuestion" => new DealsContinuousDamageQuestion(answerWeapon)
        case "HasRButtonActionQuestion" => new HasRButtonActionQuestion(answerWeapon)
        case "HasZRButtonActionQuestion" => new HasZRButtonActionQuestion(answerWeapon)
        case "JumpsToUsePointQuestion" => new JumpsToUsePointQuestion(answerWeapon)
        case "SpecialWeaponIsAttackTypeQuestion" => new SpecialWeaponIsAttackTypeQuestion(answerWeapon)
        case "SpecialWeaponNameQuestion" => new SpecialWeaponNameQuestion(answerWeapon, option.get.dropRight(1))

        case _ => throw new IllegalArgumentException("Invalid question name")
    }
}