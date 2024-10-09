package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class DodgeRollCountQuestion(
    answerWeapon: Weapon,
    targetDodgeRollCount: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.mainWeapon.dodgeRollCount, targetDodgeRollCount)) Yes
        else No
    }
}