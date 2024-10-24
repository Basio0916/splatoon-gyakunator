package domain.models

/**
 * 答えのトレイト
 */
sealed trait Answer {
  /**
   * 答えの文字列を返す
   * @return 答えの文字列
   */
  override def toString: String
}

/**
 * 「はい」を表す答え
 */
case object Yes extends Answer{
  override def toString: String = "Yes"
}

/**
 * 「いいえ」を表す答え
 */
case object No extends Answer{
  override def toString: String = "No"
}

/**
 * 「部分的にそう」を表す答え
 */
case object Partial extends Answer{
  override def toString: String = "Partial"
}

/**
 * Answerのコンパニオンオブジェクト
 */
object Answer {
  /**
   * 答えの文字列からAnswerインスタンスを返す
   * @param value 答えの文字列
   * @return Answerインスタンス
   */
  def apply(value: String): Answer = value.toLowerCase() match {
    case "yes" => Yes
    case "no" => No
    case "partial" => Partial
    case _ => throw new IllegalArgumentException(s"Answer value $value is invalid")
  }
}