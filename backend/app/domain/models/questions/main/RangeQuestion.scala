package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの射程の質問
 * @param answerWeapon 答えのブキ
 * @param targetRange 射程
 * @param comparator 比較
 */
class RangeQuestion(
    answerWeapon: Weapon,
    targetRange: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
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