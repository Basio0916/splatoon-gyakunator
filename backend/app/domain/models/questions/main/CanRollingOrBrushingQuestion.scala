package domain.models.questions.main

import domain.models._
import domain.models.questions.Question

/**
 * メインウェポンがZR長押しで塗り進みするかの質問
 * @param answerWeapon 答えのブキ
 */
class CanRollingOrBrushingQuestion(answerWeapon: Weapon) extends Question {
    /**
     * 質問に対する答えを返す
     * @return 答え
     */
    override def answer: Answer = answerWeapon.mainWeapon.canRollingOrBrushing
}