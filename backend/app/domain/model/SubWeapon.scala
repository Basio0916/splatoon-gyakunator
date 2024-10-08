package domain.model

case class SubWeapon(
    val name: String,
    val inkConsumption: Int,
    val damage: (Option[Double], Option[Double], Option[Double]),
    val isAttackType: Answer,
    val canSet: Answer,
    val canInk: Answer,
    val canSensor: Answer
)