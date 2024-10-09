package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class SubWeaponNameQuestion(answerWeapon: Weapon, targetSubWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.subWeapon.name == targetSubWeaponName) Yes
        else No
    }
}