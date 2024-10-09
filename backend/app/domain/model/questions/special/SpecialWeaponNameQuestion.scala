package domain.model.questions.special

import domain.model._
import domain.model.questions.Question

class SpecialWeaponNameQuestion(answerWeapon: Weapon, targetSpecialWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.specialWeapon.name == targetSpecialWeaponName) Yes
        else No
    }
}