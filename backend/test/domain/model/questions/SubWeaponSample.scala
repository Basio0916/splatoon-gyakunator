package domain.model.questions

import domain.model._

object SubWeaponSample{
    val splatBomb = SubWeapon(
        name = "Sスプラッシュボム",
        inkConsumption = 70,
        damage = List(180.0),
        isAttackType = Yes,
        canSet = No,
        canInk = Yes,
        canSensor = No
    )
}