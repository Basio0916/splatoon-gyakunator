package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

class SpecialWeaponNameQuestion(answerWeapon: Weapon, targetSpecialWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.specialWeapon.name == targetSpecialWeaponName) Yes
        else No
    }
}