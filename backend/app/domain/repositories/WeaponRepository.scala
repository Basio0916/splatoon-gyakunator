package domain.repositories

import domain.models.Weapon

/**
 * ブキリポジトリ
 */
trait WeaponRepository {
    /**
     * ブキを名前で検索する
     * @param name ブキ名
     * @return ブキ
     */
    def findWeaponByName(name: String): Option[Weapon]

    /**
     * ブキを行で検索する
     * @param row 行
     * @return ブキ
     */
    def findWeaponByRow(row: Int): Option[Weapon]

    /**
     * 全てのブキを取得する
     * @return 全てのブキ
     */
    def findAllWeaponNames(): Seq[String]
}