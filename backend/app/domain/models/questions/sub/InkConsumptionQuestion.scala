package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

class InkConsumptionQuestion(
    answerWeapon: Weapon,
    targetInkConsumption: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.subWeapon.inkConsumption, targetInkConsumption)) Yes
        else No
    }
}