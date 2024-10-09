package domain.model

case class Prompt(
    val mainPrompt: String,
    val subPrompt: String,
    val option: Option[String],
    val isComparable: Boolean,
    val isNumeric: Boolean,
    val unit: Option[String]
)