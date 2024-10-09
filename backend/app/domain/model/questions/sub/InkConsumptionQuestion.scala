package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class InkConsumptionQuestion(
    answerWeapon: Weapon,
    targetInkConsumption: Int,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.subWeapon.inkConsumption, targetInkConsumption)) Yes
        else No
    }
}