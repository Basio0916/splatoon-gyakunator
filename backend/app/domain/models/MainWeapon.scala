package domain.models

/**
 * メインウェポン
 * @param name 名前
 * @param weaponCategory ブキ種
 * @param range 射程
 * @param damage ダメージ
 * @param firingInterval 射撃間隔
 * @param spread 地上拡散
 * @param weight 重さ
 * @param canRapidFire ZRボタン長押しで連射するか
 * @param canCharge ZRボタン長押しでチャージするか
 * @param isExplosive 弾が爆発するか
 * @param canRollingOrBrushing ZRボタン長押しで塗り進みするか
 * @param canChargeKeep チャージキープできるか
 * @param dodgeRollCount スライド回数
 * @param hasDirectHitSound 直撃音があるか
 */
case class MainWeapon(
    val name: String,
    val weaponCategory: WeaponCategory,
    val range: Seq[Double],
    val damage: Seq[Double],
    val firingInterval: Seq[Double],
    val spread: Seq[Double],
    val weight: Weight,
    val canRapidFire: Answer,
    val canCharge: Answer,
    val isExplosive: Answer,
    val canRollingOrBrushing: Answer,
    val canChargeKeep: Answer,
    val dodgeRollCount: Int,
    val hasDirectHitSound: Answer
)