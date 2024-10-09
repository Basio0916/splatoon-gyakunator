package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

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