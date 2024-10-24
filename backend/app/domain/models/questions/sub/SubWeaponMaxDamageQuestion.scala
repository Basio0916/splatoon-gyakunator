package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

/**
 * サブウェポンの最大ダメージの質問
 * @param answerWeapon 答えのブキ
 * @param targetMaxDamage 最大ダメージ
 * @param comparator 比較
 */
class SubWeaponMaxDamageQuestion(
    answerWeapon: Weapon,
    targetMaxDamage: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.subWeapon.damage.max, targetMaxDamage)) Yes
        else No
    }
}