package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService

@Singleton
class VerifyUseCase @Inject()(jwtService: JwtService) {
    def run(jwt: String, weaponName: String): Boolean = {

        val decodedWeaponName = jwtService.decodeJwt(jwt)
        weaponName == decodedWeaponName
    }
}
