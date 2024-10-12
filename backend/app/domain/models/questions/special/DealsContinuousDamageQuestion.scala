package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

class DealsContinuousDamageQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.specialWeapon.dealsContinuousDamage
}