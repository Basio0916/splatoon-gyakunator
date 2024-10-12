package domain.models

case class MainWeapon(
    val name: String,
    val weaponCategory: WeaponCategory,
    val range: Seq[Double],
    val damage: Seq[Double],
    val firingInterval: Seq[Double],
    val spread: Seq[Double],
    val weight: Weight,
    val canRapidFire: Answer,
    val canCharge: Answer,
    val isExplosive: Answer,
    val canRollingOrBrushing: Answer,
    val canChargeKeep: Answer,
    val dodgeRollCount: Int,
    val hasDirectHitSound: Answer
)