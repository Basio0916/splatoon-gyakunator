package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class CanRapidFireQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.mainWeapon.canRapidFire
}