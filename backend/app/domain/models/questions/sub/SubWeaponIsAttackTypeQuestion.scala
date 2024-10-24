package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

/**
 * サブウェポンが攻撃タイプかの質問
 * @param answerWeapon 答えのブキ
 */
class SubWeaponIsAttackTypeQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.subWeapon.isAttackType
}