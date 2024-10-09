package domain.model

case class SubWeapon(
    val name: String,
    val inkConsumption: Int,
    val damage: Seq[Double],
    val isAttackType: Answer,
    val canBePlaced: Answer,
    val canInk: Answer,
    val canMark: Answer
)