package domain.models

/**
 * サブウェポン
 * @param name 名前
 * @param inkConsumption インク消費量
 * @param damage ダメージ
 * @param isAttackType 攻撃型か
 * @param canBePlaced 設置型か
 * @param canInk 塗りを発生させるか
 * @param canMark 相手にセンサーを付けるか
 */
case class SubWeapon(
    val name: String,
    val inkConsumption: Int,
    val damage: Seq[Double],
    val isAttackType: Answer,
    val canBePlaced: Answer,
    val canInk: Answer,
    val canMark: Answer
)