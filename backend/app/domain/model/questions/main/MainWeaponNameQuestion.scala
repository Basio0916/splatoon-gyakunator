package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class MainWeaponNameQuestion(answerWeapon: Weapon, targetMainWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.name == targetMainWeaponName) Yes
        else No
    }
}