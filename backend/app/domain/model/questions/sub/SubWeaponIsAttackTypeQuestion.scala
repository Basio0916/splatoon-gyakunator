package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class SubWeaponIsAttackTypeQuestion(answerWeapon: Weapon) extends Question {
    override def answer: Answer = answerWeapon.subWeapon.isAttackType
}