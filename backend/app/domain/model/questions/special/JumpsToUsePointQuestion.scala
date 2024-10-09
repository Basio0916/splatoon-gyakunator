package domain.model.questions.special

import domain.model._
import domain.model.questions.Question

class JumpsToUsePointQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.specialWeapon.jumpsToUsePoint
}