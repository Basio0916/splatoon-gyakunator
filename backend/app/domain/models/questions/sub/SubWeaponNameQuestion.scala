package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

class SubWeaponNameQuestion(answerWeapon: Weapon, targetSubWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.subWeapon.name == targetSubWeaponName) Yes
        else No
    }
}