package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

class CanMarkQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.canMark
}