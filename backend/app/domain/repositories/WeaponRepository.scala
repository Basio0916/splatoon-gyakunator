package domain.repositories

import domain.models.Weapon

trait WeaponRepository {
    def findWeaponByName(name: String): Option[Weapon]
    def findWeaponByRow(row: Int): Option[Weapon]
    def findAllWeaponNames(): List[String]
}