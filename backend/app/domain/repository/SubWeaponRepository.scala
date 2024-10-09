package domain.repository

import domain.model.SubWeapon

trait SubWeaponRepository {
    def findSubWeaponByName(name: String): Option[SubWeapon]
}