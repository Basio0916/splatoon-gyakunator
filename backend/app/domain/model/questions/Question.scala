package domain.model.questions

import domain.model._
import domain.model.questions.main._

trait Question{
    def answer: Answer
}

object Question {
    def apply(questionName: String, answerWeapon: Weapon, option: Option[String], comparator: Option[Comparator]): Question = questionName match {
        case "WeaponCategoryQuestion" => new WeaponCategoryQuestion(answerWeapon, WeaponCategory(option.get))
    }
}