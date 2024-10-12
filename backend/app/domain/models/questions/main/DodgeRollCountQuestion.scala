package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

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