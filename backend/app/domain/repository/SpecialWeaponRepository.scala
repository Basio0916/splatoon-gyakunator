package domain.repository

import domain.model.SpecialWeapon

trait SpecialWeaponRepository {
    def findSpecialWeaponByName(name: String): Option[SpecialWeapon]
}