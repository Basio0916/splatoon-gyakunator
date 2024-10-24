package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンのスライド回数の質問
 * @param answerWeapon 答えのブキ
 * @param targetSlideCount スライド回数
 * @param comparator 比較方法
 */
class DodgeRollCountQuestion(
    answerWeapon: Weapon,
    targetDodgeRollCount: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.mainWeapon.dodgeRollCount, targetDodgeRollCount)) Yes
        else No
    }
}