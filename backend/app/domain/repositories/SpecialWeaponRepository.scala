package domain.repositories

import domain.models.SpecialWeapon

/**
 * スペシャルウェポンリポジトリ
 */
trait SpecialWeaponRepository {
    /**
     * スペシャルウェポンを名前で検索する
     * @param name スペシャルウェポン名
     * @return スペシャルウェポン
     */
    def findSpecialWeaponByName(name: String): Option[SpecialWeapon]
}