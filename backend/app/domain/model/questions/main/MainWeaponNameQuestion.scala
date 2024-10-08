package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class MainWeaponNameQuestion(answerWeapon: Weapon, mainWeaponName: String) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.name == mainWeaponName) Yes
        else No
    }
}