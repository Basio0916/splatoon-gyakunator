package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class CanBePlacedQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.canBePlaced
}