package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class MainWeaponMaxDamageQuestion(
    answerWeapon: Weapon,
    targetMaxDamage: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.mainWeapon.damage.max, targetMaxDamage)) Yes
        else No
    }
}