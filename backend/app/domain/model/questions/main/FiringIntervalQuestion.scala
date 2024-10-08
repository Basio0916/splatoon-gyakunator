package domain.model.questions.main

import domain.model._
import domain.model.questions.Question

class FiringIntervalQuestion(answerWeapon: Weapon, firingIntervalString: String, comparator: Comparator) extends Question {
    override def answer: Answer = {
        var matchCount = 0
        val firingIntervalNumber = firingIntervalString.toDouble
        for(firingInterval <- answerWeapon.mainWeapon.firingInterval) {
            if(comparator.compare(firingInterval, firingIntervalNumber)) matchCount += 1
        }
        if(matchCount == 0) No
        else if(matchCount == answerWeapon.mainWeapon.firingInterval.length) Yes
        else Partial
    }
}