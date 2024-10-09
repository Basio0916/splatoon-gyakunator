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
        jumpsToUsePoint = No
    )

    val bigBubbler = SpecialWeapon(
        name = "グレートバリア",
        hasZRButtonAction = No,
        hasRButtonAction = No,
        canOneShot = No,
        dealsContinuousDamage = No,
        isAttackType = No,
        jumpsToUsePoint = Yes
    )

    val crabTank = SpecialWeapon(
        name = "カニタンク",
        hasZRButtonAction = Yes,
        hasRButtonAction = Yes,
        canOneShot = No,
        dealsContinuousDamage = No,
        isAttackType = Yes,
        jumpsToUsePoint = No
    )

    val partiallySpecialWeapon = SpecialWeapon(
        name = "imaginarySpecialWeapon",
        hasZRButtonAction = Partial,
        hasRButtonAction = Partial,
        canOneShot = Partial,
        dealsContinuousDamage = Partial,
        isAttackType = Partial,
        jumpsToUsePoint = Partial
    )
}