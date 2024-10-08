package domain.model

case class Weapon(
    val name: String, 
    val mainWeapon: MainWeapon, 
    val subWeapon: SubWeapon, 
    val specialWeapon: SpecialWeapon, 
    val specialPoint: Int
)