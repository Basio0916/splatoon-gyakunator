package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンが持続ダメージを与えるかの質問
 * @param answerWeapon 答えのブキ
 */
class DealsContinuousDamageQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.specialWeapon.dealsContinuousDamage
}