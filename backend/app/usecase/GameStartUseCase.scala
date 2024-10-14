package usecase

import javax.inject.Inject
import domain.repositories.WeaponRepository
import domain.services.JwtService

class GameStartUseCase @Inject()(weaponRepository: WeaponRepository, jwtService: JwtService) {
    def run(): String = {
        val weaponNames = weaponRepository.findAllWeaponNames()
        val weaponName = weaponNames(scala.util.Random.nextInt(weaponNames.length))
        jwtService.generateJwt(weaponName)
    }
  
}
