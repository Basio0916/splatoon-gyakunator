package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの地上拡散の質問
 * @param answerWeapon 答えのブキ
 * @param targetSpread 地上拡散
 * @param comparator 比較
 */
class SpreadQuestion(
    answerWeapon: Weapon,
    targetSpread: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
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