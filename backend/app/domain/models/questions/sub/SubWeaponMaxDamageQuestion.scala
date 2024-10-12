package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

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