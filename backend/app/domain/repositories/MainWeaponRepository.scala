package domain.repositories

import domain.models.MainWeapon

trait MainWeaponRepository {
    def findMainWeaponByName(name: String): Option[MainWeapon]
}