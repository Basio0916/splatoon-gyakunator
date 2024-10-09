package domain.repository

import domain.model.SpecialWeapon

trait SupecialWeaponRepository {
    def findSpecialWeaponByName(name: String): Option[SpecialWeapon]
}