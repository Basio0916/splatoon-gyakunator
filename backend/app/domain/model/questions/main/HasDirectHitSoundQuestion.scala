package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class HasDirectHitSoundQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.mainWeapon.hasDirectHitSound
}