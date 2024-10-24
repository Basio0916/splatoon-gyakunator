package domain.models

/**
 * スペシャルウェポン
 * @param name 名前
 * @param hasZRButtonAction ZRボタンでアクションするか
 * @param hasRButtonAction Rボタンでアクションするか
 * @param canOneShot 1発で倒せるか
 * @param dealsContinuousDamage 継続的にダメージを与えるか
 * @param isAttackType 攻撃型か
 * @param jumpsToUsePoint 味方のスーパージャンプが発動地点にジャンプするか
 */

case class SpecialWeapon(
    val name: String,
    val hasZRButtonAction: Answer,
    val hasRButtonAction: Answer,
    val canOneShot: Answer,
    val dealsContinuousDamage: Answer,
    val isAttackType: Answer,
    val jumpsToUsePoint: Answer,
)