package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンのブキ種の質問
 * @param answerWeapon 答えのブキ
 * @param weaponCategory ブキ種
 */
class WeaponCategoryQuestion(answerWeapon: Weapon, weaponCategory: WeaponCategory) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.weaponCategory == weaponCategory) Yes
        else No
    }
}