package domain.model

case class MainWeapon(
    val name: String,
    val weaponCategory: WeaponCategory,
    val range: (Option[Double], Option[Double]),
    val damage: (Option[Double], Option[Double], Option[Double], Option[Double]),
    val firingInterval: (Option[Double], Option[Double]),
    val spread: (Option[Double], Option[Double]),
    val weight: Weight,
    val canRapidFire: Answer,
    val canCharge: Answer,
    val isExplosive: Answer,
    val canRollingOrBrushing: Answer,
    val canChargeKeep: Answer,
    val dodgeRollCount: Int,
    val hasDirectHitSound: Answer
)