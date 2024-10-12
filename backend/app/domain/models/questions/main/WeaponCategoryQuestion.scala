package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class WeaponCategoryQuestion(answerWeapon: Weapon, weaponCategory: WeaponCategory) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.weaponCategory == weaponCategory) Yes
        else No
    }
}