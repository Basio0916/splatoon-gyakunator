case class MainWeapon(
    name: String,
    category: WeaponCategory,
    range: (Double, Double),
    damage: (Double, Double, Double, Double),
    rate: (Double, Double),
    spread: (Double, Double),
    weight: Weight,
    price: Int,
    canRapidFire: Answer,
    canCharge: Answer,
    isExplosive: Answer,
    canRollingOrBrushing: Answer,
    canChargeKeep: Answer,
    dodgeRollCount: Int,
    hasDirectHitSound: Answer
)