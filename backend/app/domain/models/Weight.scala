package domain.models

/**
 * ブキの重さ
 * 比較演算子で比較が可能
 */
sealed trait Weight extends Ordered[Weight] {

  /**
   * 重さの値
   */
  def value: Int

  /**
   * 重さの比較
   * @param that 比較対象
   * @return 比較結果
   */
  override def compare(that: Weight): Int = this.value - that.value
}

/**
 * 最軽量級
 */
case object ExtraLight extends Weight {
  override val value: Int = 0
}

/**
 * 軽量級
 */
case object Light extends Weight {
  override val value: Int = 1
}

/**
 * 中量級
 */
case object Middle extends Weight {
  override val value: Int = 2
}

/**
 * 重量級
 */
case object Heavy extends Weight {
  override val value: Int = 3
}

/**
 * Weightのコンパニオンオブジェクト
 */
object Weight{
    /**
     * 重さの文字列からWeightインスタンスを返す
     * @param value 重さの文字列
     * @return Weightインスタンス
     */
    def apply(value: String): Weight = value match {
      case "最軽量級" => ExtraLight
      case "軽量級" => Light
      case "中量級" => Middle
      case "重量級" => Heavy
      case _ => throw new IllegalArgumentException(s"Weight value $value is invalid")
    }
}