package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの射撃間隔の質問
 * @param answerWeapon 答えのブキ
 * @param targetFiringInterval 射撃間隔
 * @param comparator 比較
 */
class FiringIntervalQuestion(
    answerWeapon: Weapon,
    targetFiringInterval: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
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