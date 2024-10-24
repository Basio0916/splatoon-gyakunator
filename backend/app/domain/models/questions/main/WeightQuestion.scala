package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの重さの質問
 * @param answerWeapon 答えのブキ
 * @param targetWeight 重さ
 * @param comparator 比較
 */
class WeightQuestion(
    answerWeapon: Weapon,
    targetWeight: Weight,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.mainWeapon.weight, targetWeight)) Yes
        else No
    }
}