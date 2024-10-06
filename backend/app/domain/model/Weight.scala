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
    def from(value: Int): Weight = value match {
        case 0 => ExtraLight
        case 1 => Light
        case 2 => Middle
        case 3 => Heavy
        case _ => throw new IllegalArgumentException(s"Weight value $value is invalid")
    }
}