package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class CanChargeQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.mainWeapon.canCharge
}