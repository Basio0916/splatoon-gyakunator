sealed trait WeaponCategory {
  override def toString: String
}

case object Shooter extends WeaponCategory {
    override def toString: String = "シューター"
}
case object Roller extends WeaponCategory{
    override def toString: String = "ローラー"
}
case object Charger extends WeaponCategory{
    override def toString: String = "チャージャー"
}
case object Slosher extends WeaponCategory{
    override def toString: String = "スロッシャー"
}
case object Blaster extends WeaponCategory{
    override def toString: String = "ブラスター"
}
case object Splatling extends WeaponCategory{
    override def toString: String = "スピナー"
}
case object Brella extends WeaponCategory{
    override def toString: String = "シェルター"
}
case object Dualies extends WeaponCategory{
    override def toString: String = "マニューバー"
}
case object Brush extends WeaponCategory{
    override def toString: String = "フデ"
}
case object Stringers extends WeaponCategory{
    override def toString: String = "ストリンガー"
}
case object Splatanas extends WeaponCategory{
    override def toString: String = "ワイパー"
}

object WeaponCategory{
    def from(value: String): WeaponCategory = value match {
        case "シューター" => Shooter
        case "ローラー" => Roller
        case "チャージャー" => Charger
        case "スロッシャー" => Slosher
        case "ブラスター" => Blaster
        case "スピナー" => Splatling
        case "シェルター" => Brella
        case "マニューバー" => Dualies
        case "フデ" => Brush
        case "ストリンガー" => Stringers
        case "ワイパー" => Splatanas
        case _ => throw new IllegalArgumentException(s"WeaponCategory value $value is invalid")
    }
}