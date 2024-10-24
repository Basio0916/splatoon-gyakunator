package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンは攻撃系かの質問
 * @param answerWeapon 答えのブキ
 */
class SpecialWeaponIsAttackTypeQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.specialWeapon.isAttackType
}