package domain.models

case class SpecialWeapon(
    val name: String,
    val hasZRButtonAction: Answer,
    val hasRButtonAction: Answer,
    val canOneShot: Answer,
    val dealsContinuousDamage: Answer,
    val isAttackType: Answer,
    val jumpsToUsePoint: Answer,
)