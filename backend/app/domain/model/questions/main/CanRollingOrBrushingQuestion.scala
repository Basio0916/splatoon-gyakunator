package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class CanRollingOrBrushingQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.mainWeapon.canRollingOrBrushing
}