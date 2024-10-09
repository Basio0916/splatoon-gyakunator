package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

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