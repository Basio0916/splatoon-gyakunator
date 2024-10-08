trait Question{
    def answer: Answer
}

object Question {
    def apply(questionName: String, answerWeapon: Weapon, option: Option[String], comparator: Option[Comparator]): Question = questionName match {
        case "MainWeaponCategoryQuestion" => new MainWeaponCategoryQuestion(answerWeapon, WeaponCategory(option.get))
    }
}