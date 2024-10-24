package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンがチャージできるかの質問
 * @param answerWeapon 答えのブキ
 */
class CanChargeQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.mainWeapon.canCharge
}