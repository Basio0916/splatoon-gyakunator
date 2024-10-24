package domain.repositories

import domain.models.MainWeapon

/**
 * メインウェポンリポジトリ
 */
trait MainWeaponRepository {
    /**
     * メインウェポンを名前で検索する
     * @param name メインウェポン名
     * @return メインウェポン
     */
    def findMainWeaponByName(name: String): Option[MainWeapon]
}