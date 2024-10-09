package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class CanMarkQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.canMark
}