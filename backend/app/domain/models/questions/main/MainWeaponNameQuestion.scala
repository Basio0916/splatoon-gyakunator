package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンの名前の質問
 * @param answerWeapon 答えのブキ
 * @param targetMainWeaponName メインウェポンの名前
 */
class MainWeaponNameQuestion(answerWeapon: Weapon, targetMainWeaponName: String) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.name == targetMainWeaponName) Yes
        else No
    }
}