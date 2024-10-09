package domain.model.questions.main

import domain.model._

object MainWeaponSample {
    val splattershotJr = MainWeapon(
        name = "わかばシューター", 
        weaponCategory = WeaponCategory("シューター"),
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
        weaponCategory = WeaponCategory("シューター"),
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
        weaponCategory = WeaponCategory("シューター"),
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
        weaponCategory = WeaponCategory("ブラスター"),
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
}