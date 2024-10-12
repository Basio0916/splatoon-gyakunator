package domain.repositories

import domain.models.SpecialWeapon

trait SpecialWeaponRepository {
    def findSpecialWeaponByName(name: String): Option[SpecialWeapon]
}