package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository

@Singleton
class GetWeaponNamesUseCase @Inject()(weaponRepository: WeaponRepository){
    def run(): List[String] = {
        weaponRepository.findAllWeaponNames()
    }
}
