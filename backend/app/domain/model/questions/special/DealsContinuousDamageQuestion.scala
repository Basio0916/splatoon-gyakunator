package domain.model.questions.special

import domain.model._
import domain.model.questions.Question

class DealsContinuousDamageQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.specialWeapon.dealsContinuousDamage
}