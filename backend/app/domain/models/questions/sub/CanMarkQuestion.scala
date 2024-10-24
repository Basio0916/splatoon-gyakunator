package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

/**
 * サブウェポンが相手にセンサーを付けるかの質問
 * @param answerWeapon 答えのブキ
 */
class CanMarkQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.subWeapon.canMark
}