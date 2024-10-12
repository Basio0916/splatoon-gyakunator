package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

class CanBePlacedQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.canBePlaced
}