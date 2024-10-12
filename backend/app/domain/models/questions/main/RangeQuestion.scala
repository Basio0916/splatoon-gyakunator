package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class RangeQuestion(
    answerWeapon: Weapon,
    targetRange: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        var matchCount = 0
        for(range <- answerWeapon.mainWeapon.range) {
            if(comparator.compare(range, targetRange)) matchCount += 1
        }
        if(matchCount == 0) No
        else if(matchCount == answerWeapon.mainWeapon.range.length) Yes
        else Partial
    }
}