package domain.model

import play.api.libs.json._

sealed trait Weight extends Ordered[Weight] {
  def value: Int
  override def compare(that: Weight): Int = this.value - that.value
}

case object ExtraLight extends Weight {
  override val value: Int = 0
}

case object Light extends Weight {
  override val value: Int = 1
}

case object Middle extends Weight {
  override val value: Int = 2
}

case object Heavy extends Weight {
  override val value: Int = 3
}

object Weight{
    def apply(value: String): Weight = value match {
      case "最軽量級" => ExtraLight
      case "軽量級" => Light
      case "中量級" => Middle
      case "重量級" => Heavy
      case _ => throw new IllegalArgumentException(s"Weight value $value is invalid")
    }

      implicit val weightReads: Reads[Weight] = Reads {
        case JsString(s) => JsSuccess(Weight(s))
        case _ => JsError("Could not read Weight")
    }
}