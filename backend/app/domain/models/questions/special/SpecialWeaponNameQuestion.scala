package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンの名前の質問
 * @param answerWeapon 答えのブキ
 * @param targetSpecialWeaponName スペシャルウェポン名
 */
class SpecialWeaponNameQuestion(answerWeapon: Weapon, targetSpecialWeaponName: String) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if (answerWeapon.specialWeapon.name == targetSpecialWeaponName) Yes
        else No
    }
}