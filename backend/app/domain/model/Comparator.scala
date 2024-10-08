package domain.model

sealed trait Comparator{
    def compare[T : Ordering](a: T, b: T): Boolean
}

object GreaterThanOrEqual extends Comparator{
    override def compare[T : Ordering](a: T, b: T): Boolean = implicitly[Ordering[T]].gteq(a, b)
}

object LessThanOrEqual extends Comparator{
    override def compare[T : Ordering](a: T, b: T): Boolean = implicitly[Ordering[T]].lteq(a, b)
}

object Equal extends Comparator{
    override def compare[T : Ordering](a: T, b: T): Boolean = implicitly[Ordering[T]].equiv(a, b)
}

object Comparator {
    def apply(s: String): Comparator = s match {
        case "以上？" => GreaterThanOrEqual
        case "以下？" => LessThanOrEqual
        case "？" => Equal
        case _ => throw new IllegalArgumentException(s"Comparator value $s is invalid")
    }
}