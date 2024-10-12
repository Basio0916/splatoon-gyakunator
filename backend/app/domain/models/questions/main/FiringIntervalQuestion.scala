package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

class FiringIntervalQuestion(
    answerWeapon: Weapon,
    targetFiringInterval: Double,
    comparator: Comparator
) extends Question {
    override def answer: Answer = {
        var matchCount = 0
        for(firingInterval <- answerWeapon.mainWeapon.firingInterval) {
            if(comparator.compare(firingInterval, targetFiringInterval)) matchCount += 1
        }
        if(matchCount == 0) No
        else if(matchCount == answerWeapon.mainWeapon.firingInterval.length) Yes
        else Partial
    }
}