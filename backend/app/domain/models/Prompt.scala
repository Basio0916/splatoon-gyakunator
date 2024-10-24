package domain.models

/**
 * プロンプト
 * @param mainPrompt メインプロンプト
 * @param subPrompt サブプロンプト
 * @param option オプション
 * @param isComparable 比較可能か
 * @param isNumeric 数値か
 * @param unit 単位
 */
case class Prompt(
    val mainPrompt: String,
    val subPrompt: String,
    val option: Option[String],
    val isComparable: Boolean,
    val isNumeric: Boolean,
    val unit: Option[String]
)