package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class IsExplosiveQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.mainWeapon.isExplosive
}