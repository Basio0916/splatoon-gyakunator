package domain.models

/**
 * ブキ種のトレイト
 */
sealed trait WeaponCategory {
    /**
     * ブキ種の名前を返す
     * @return ブキ種の名前
     */
    override def toString: String
}

/**
 * シューター
 */
case object Shooter extends WeaponCategory {
    override def toString: String = "シューター"
}

/**
 * ローラー
 */
case object Roller extends WeaponCategory{
    override def toString: String = "ローラー"
}

/**
 * チャージャー
 */
case object Charger extends WeaponCategory{
    override def toString: String = "チャージャー"
}

/**
 * スロッシャー
 */
case object Slosher extends WeaponCategory{
    override def toString: String = "スロッシャー"
}

/**
 * ブラスター
 */
case object Blaster extends WeaponCategory{
    override def toString: String = "ブラスター"
}

/**
 * スピナー
 */
case object Splatling extends WeaponCategory{
    override def toString: String = "スピナー"
}

/**
 * シェルター
 */
case object Brella extends WeaponCategory{
    override def toString: String = "シェルター"
}

/**
 * マニューバー
 */
case object Dualies extends WeaponCategory{
    override def toString: String = "マニューバー"
}

/**
 * フデ
 */
case object Brush extends WeaponCategory{
    override def toString: String = "フデ"
}

/**
 * ストリンガー
 */
case object Stringer extends WeaponCategory{
    override def toString: String = "ストリンガー"
}

/**
 * ワイパー
 */
case object Splatana extends WeaponCategory{
    override def toString: String = "ワイパー"
}

/**
 * WeaponCategoryのコンパニオンオブジェクト
 */
object WeaponCategory{
    /**
     * ブキ種の文字列からWeaponCategoryインスタンスを返す
     * @param value ブキ種の文字列
     * @return WeaponCategoryインスタンス
     */
    def apply(value: String): WeaponCategory = value match {
        case "シューター" => Shooter
        case "ローラー" => Roller
        case "チャージャー" => Charger
        case "スロッシャー" => Slosher
        case "ブラスター" => Blaster
        case "スピナー" => Splatling
        case "シェルター" => Brella
        case "マニューバー" => Dualies
        case "フデ" => Brush
        case "ストリンガー" => Stringer
        case "ワイパー" => Splatana
        case _ => throw new IllegalArgumentException(s"WeaponCategory value $value is invalid")
    }
}