sealed trait Answer {
  override def toString: String
}

case object Yes extends Answer{
  override def toString: String = "Yes"
}
case object No extends Answer{
  override def toString: String = "No"
}
case object Partial extends Answer{
  override def toString: String = "Partial"
}

object Answer {
  def from(value: String): Answer = value.toLowerCase() match {
    case "yes" => Yes
    case "no" => No
    case "partial" => Partial
    case _ => throw new IllegalArgumentException(s"Answer value $value is invalid")
  }
}