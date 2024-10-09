package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class CanInkQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.canInk
}