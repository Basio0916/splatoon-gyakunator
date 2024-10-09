package domain.model.questions

import domain.model._

object SpecialWeaponSample{
    val trizooka = SpecialWeapon(
        name = "ウルトラショット",
        hasZRButtonAction = Yes,
        hasRButtonAction = No,
        canOneShot = Yes,
        dealsContinuousDamage = No,
        isAttackType = Yes,
        jumpsToUsePoint = Yes
    )
}