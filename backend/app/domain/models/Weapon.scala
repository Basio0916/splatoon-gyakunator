package domain.models

/**
 * ブキ
 * @param name 名前
 * @param mainWeapon メインウェポン
 * @param subWeapon サブウェポン
 * @param specialWeapon スペシャルウェポン
 * @param specialPoint スペシャル必要ポイント
 */
case class Weapon(
    val name: String, 
    val mainWeapon: MainWeapon, 
    val subWeapon: SubWeapon, 
    val specialWeapon: SpecialWeapon, 
    val specialPoint: Int
)