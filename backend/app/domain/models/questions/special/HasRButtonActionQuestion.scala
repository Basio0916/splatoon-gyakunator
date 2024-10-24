package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンはRボタンでアクションするかの質問
 * @param answerWeapon 答えのブキ
 */
class HasRButtonActionQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.specialWeapon.hasRButtonAction
}