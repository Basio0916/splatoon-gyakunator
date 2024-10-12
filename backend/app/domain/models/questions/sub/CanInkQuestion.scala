package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

class CanInkQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.canInk
}