package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンはZRボタンでアクションするかの質問
 * @param answerWeapon 答えのブキ
 */
class HasZRButtonActionQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.specialWeapon.hasZRButtonAction
}