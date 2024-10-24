package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

/**
 * サブウェポンのインク消費量の質問
 * @param answerWeapon 答えのブキ
 * @param targetInkConsumption インク消費量
 * @param comparator 比較
 */
class InkConsumptionQuestion(
    answerWeapon: Weapon,
    targetInkConsumption: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.subWeapon.inkConsumption, targetInkConsumption)) Yes
        else No
    }
}