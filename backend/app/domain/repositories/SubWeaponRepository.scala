package domain.repositories

import domain.models.SubWeapon

trait SubWeaponRepository {
    def findSubWeaponByName(name: String): Option[SubWeapon]
}