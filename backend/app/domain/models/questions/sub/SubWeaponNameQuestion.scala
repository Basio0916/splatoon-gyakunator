package domain.models.questions.sub

import domain.models._
import domain.models.questions.Question

/**
 * サブウェポンの名前の質問
 * @param answerWeapon 答えのブキ
 * @param targetSubWeaponName サブウェポン名
 */
class SubWeaponNameQuestion(answerWeapon: Weapon, targetSubWeaponName: String) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if (answerWeapon.subWeapon.name == targetSubWeaponName) Yes
        else No
    }
}