package usecase

import domain.repositories.WeaponRepository

class GetWeaponNamesUseCase (weaponRepository: WeaponRepository){
    def run(): List[String] = {
        weaponRepository.findAllWeaponNames()
    }
}
