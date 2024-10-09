package domain.model.questions.special

import domain.model._
import domain.model.questions.Question

class CanOneShotQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.specialWeapon.canOneShot
}