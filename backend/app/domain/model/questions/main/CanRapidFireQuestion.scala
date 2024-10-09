package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class CanRapidFireQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.mainWeapon.canRapidFire
}