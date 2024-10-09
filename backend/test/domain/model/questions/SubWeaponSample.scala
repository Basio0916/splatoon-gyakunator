package domain.model.questions

import domain.model._

object SubWeaponSample{
    val splatBomb = SubWeapon(
        name = "スプラッシュボム",
        inkConsumption = 70,
        damage = List(180.0, 30.0),
        isAttackType = Yes,
        canBePlaced = No,
        canInk = Yes,
        canMark = No
    )

    val squidBeakon = SubWeapon(
        name = "ジャンプビーコン",
        inkConsumption = 75,
        damage = List(0.0),
        isAttackType = No,
        canBePlaced = Yes,
        canInk = No,
        canMark = No
    )

    val partiallySubWeapon = SubWeapon(
        name = "imaginarySubWeapon",
        inkConsumption = 70,
        damage = List(180.0, 30.0),
        isAttackType = Partial,
        canBePlaced = Partial,
        canInk = Partial,
        canMark = Partial
    )
}