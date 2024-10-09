package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class SpreadQuestion(
    answerWeapon: Weapon,
    targetSpread: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        var matchCount = 0
        for(spread <- answerWeapon.mainWeapon.spread) {
            if(comparator.compare(spread, targetSpread)) matchCount += 1
        }
        if(matchCount == 0) No
        else if(matchCount == answerWeapon.mainWeapon.spread.length) Yes
        else Partial
    }
}