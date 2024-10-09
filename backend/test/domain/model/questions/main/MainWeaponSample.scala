package domain.model.questions.main

import domain.model._

object MainWeaponSample {
    val splattershotJr = MainWeapon(
        name = "わかばシューター", 
        weaponCategory = Shooter,
        range = List(2.0),
        damage = List(28.0),
        firingInterval = List(5.0),
        spread = List(12.0),
        weight = Light,
        canRapidFire = Yes,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )
    val l3Nozzlenose = MainWeapon(
        name = "L3リールガン", 
        weaponCategory = Shooter,
        range = List(2.7),
        damage = List(29.0),
        firingInterval = List(4.0, 9.0),
        spread = List(1.0),
        weight = Middle,
        canRapidFire = No,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )
    val squeezer = MainWeapon(
        name = "ボトルガイザー", 
        weaponCategory = Shooter,
        range = List(3.3, 2.2),
        damage = List(38.0, 30.0),
        firingInterval = List(8.0, 7.0),
        spread = List(0.0, 8.0),
        weight = Middle,
        canRapidFire = Yes,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )
    val lunaBlaster = MainWeapon(
        name = "ノヴァブラスター", 
        weaponCategory = Blaster,
        range = List(1.6),
        damage = List(125.0, 70),
        firingInterval = List(40.0),
        spread = List(0.0),
        weight = Light,
        canRapidFire = Yes,
        canCharge = No,
        isExplosive = Yes,
        canRollingOrBrushing = No,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = Yes
    )
    val splatCharger = MainWeapon(
        name = "スプラチャージャー", 
        weaponCategory = Charger,
        range = List(5.3),
        damage = List(160.0),
        firingInterval = List(66.0, 14.0),
        spread = List(0.0),
        weight = Middle,
        canRapidFire = No,
        canCharge = Yes,
        isExplosive = No,
        canRollingOrBrushing = No,
        canChargeKeep = Yes,
        dodgeRollCount = 0,
        hasDirectHitSound = Yes
    )
    val splatRoller = MainWeapon(
        name = "スプラローラー", 
        weaponCategory = Roller,
        range = List(1.4, 1.7),
        damage = List(150.0),
        firingInterval = List(42.0),
        spread = List(16.0),
        weight = Middle,
        canRapidFire = No,
        canCharge = No,
        isExplosive = No,
        canRollingOrBrushing = Yes,
        canChargeKeep = No,
        dodgeRollCount = 0,
        hasDirectHitSound = No
    )
    val partiallyMainWeapon = MainWeapon(
        name = "imaginaryWeapon", 
        weaponCategory = Shooter,
        range = List(0.0),
        damage = List(0.0),
        firingInterval = List(0.0),
        spread = List(0.0),
        weight = Light,
        canRapidFire = Partial,
        canCharge = Partial,
        isExplosive = Partial,
        canRollingOrBrushing = Partial,
        canChargeKeep = Partial,
        dodgeRollCount = 0,
        hasDirectHitSound = Partial
    )
}