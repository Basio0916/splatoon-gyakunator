package domain.repository

import domain.model.MainWeapon

trait MainWeaponRepository {
    def findMainWeaponByName(name: String): Option[MainWeapon]
}