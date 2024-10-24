package domain.models.questions.special

import domain.models._
import domain.models.questions.Question

/**
 * スペシャルウェポンは味方のスーパージャンプが発動地点にジャンプするかの質問
 * @param answerWeapon 答えのブキ
 */
class JumpsToUsePointQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.specialWeapon.jumpsToUsePoint
}