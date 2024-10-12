package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class MainWeaponNameQuestion(answerWeapon: Weapon, targetMainWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.name == targetMainWeaponName) Yes
        else No
    }
}