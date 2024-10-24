package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの最大ダメージの質問
 * @param answerWeapon 答えのブキ
 * @param targetMaxDamage 最大ダメージ
 * @param comparator 比較
 */
class MainWeaponMaxDamageQuestion(
    answerWeapon: Weapon,
    targetMaxDamage: Double,
    comparator: Comparator
) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if(comparator.compare(answerWeapon.mainWeapon.damage.max, targetMaxDamage)) Yes
        else No
    }
}