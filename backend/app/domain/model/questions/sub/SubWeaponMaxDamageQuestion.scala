package domain.model.questions.sub

import domain.model._
import domain.model.questions.Question

class SubWeaponMaxDamageQuestion(
    answerWeapon: Weapon,
    targetMaxDamage: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.subWeapon.damage.max, targetMaxDamage)) Yes
        else No
    }
}