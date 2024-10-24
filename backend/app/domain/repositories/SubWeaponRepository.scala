package domain.repositories

import domain.models.SubWeapon

/**
 * サブウェポンリポジトリ
 */
trait SubWeaponRepository {
    /**
     * サブウェポンを名前で検索する
     * @param name サブウェポン名
     * @return サブウェポン
     */
    def findSubWeaponByName(name: String): Option[SubWeapon]
}