package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class WeaponCategoryQuestion(answerWeapon: Weapon, weaponCategory: WeaponCategory) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.weaponCategory == weaponCategory) Yes
        else No
    }
}