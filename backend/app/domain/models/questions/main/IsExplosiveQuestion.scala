package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの弾が爆発するかの質問
 * @param answerWeapon 答えのブキ
 */
class IsExplosiveQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.mainWeapon.isExplosive
}