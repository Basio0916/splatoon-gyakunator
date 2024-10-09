package domain.model

case class Prompt(
    mainPrompt: String,
    subPrompt: String,
    option: Option[String],
    isComparable: Boolean,
    isNumeric: Boolean,
    unit: Option[String]
)