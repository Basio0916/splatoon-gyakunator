package domain.repositories

import domain.models.Prompt

/**
 * プロンプトリポジトリ
 */
trait PromptRepository {
    /**
     * 全てのプロンプトを取得する
     * @return 全てのプロンプト
     */
    def findAllPrompts(): Seq[Prompt]
}