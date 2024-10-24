package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンで1発で倒せるかの質問
 * @param answerWeapon 答えのブキ
 */
class CanOneShotQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.specialWeapon.canOneShot
}