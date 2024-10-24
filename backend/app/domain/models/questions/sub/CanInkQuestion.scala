package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

/**
 * サブウェポンが塗りを発生させるかの質問
 * @param answerWeapon 答えのブキ
 */
class CanInkQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.subWeapon.canInk
}