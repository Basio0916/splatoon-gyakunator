case class MainWeapon(
    val name: String,
    val weaponCategory: WeaponCategory,
    val range: (Option[Double], Option[Double]),
    val damage: (Option[Double], Option[Double], Option[Double], Option[Double]),
    val rate: (Option[Double], Option[Double]),
    val spread: (Option[Double], Option[Double]),
    val weight: Weight,
    val price: Int,
    val canRapidFire: Answer,
    val canCharge: Answer,
    val isExplosive: Answer,
    val canRollingOrBrushing: Answer,
    val canChargeKeep: Answer,
    val dodgeRollCount: Int,
    val hasDirectHitSound: Answer
)