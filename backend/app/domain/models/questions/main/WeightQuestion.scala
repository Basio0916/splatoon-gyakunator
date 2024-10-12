package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class WeightQuestion(
    answerWeapon: Weapon,
    targetWeight: Weight,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.mainWeapon.weight, targetWeight)) Yes
        else No
    }
}