package usecase

import domain.repositories.WeaponRepository
import javax.inject.Inject

class GetWeaponNamesUseCase @Inject()(weaponRepository: WeaponRepository){
    def run(): List[String] = {
        weaponRepository.findAllWeaponNames()
    }
}
