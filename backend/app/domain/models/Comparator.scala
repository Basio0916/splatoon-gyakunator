package domain.models

/**
 * 比較のトレイト
 */
sealed trait Comparator{
    /**
     * 比較を行う
     * @param a 比較する値
     * @param b 比較する値
     * @return 比較結果
     */
    def compare[T : Ordering](a: T, b: T): Boolean
}

/**
 * 以上を表す比較
 */
object GreaterThanOrEqual extends Comparator{
    override def compare[T : Ordering](a: T, b: T): Boolean = implicitly[Ordering[T]].gteq(a, b)
}

/**
 * 以下を表す比較
 */
object LessThanOrEqual extends Comparator{
    override def compare[T : Ordering](a: T, b: T): Boolean = implicitly[Ordering[T]].lteq(a, b)
}

/**
 * 等しいを表す比較
 */
object Equal extends Comparator{
    override def compare[T : Ordering](a: T, b: T): Boolean = implicitly[Ordering[T]].equiv(a, b)
}

/**
 * Comparatorのコンパニオンオブジェクト
 */
object Comparator {
    /**
     * 比較の文字列からComparatorインスタンスを返す
     * @param s 比較の文字列
     * @return Comparatorインスタンス
     */
    def apply(s: String): Comparator = s match {
        case "以上？" => GreaterThanOrEqual
        case "以下？" => LessThanOrEqual
        case "？" => Equal
        case _ => throw new IllegalArgumentException(s"Comparator value $s is invalid")
    }
}