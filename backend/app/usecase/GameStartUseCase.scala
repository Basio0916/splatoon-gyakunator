package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService

/**
 * ゲーム開始ユースケース
 * @param weaponRepository ブキリポジトリ
 * @param jwtService JWTサービス
 */
@Singleton
class GameStartUseCase @Inject()(weaponRepository: WeaponRepository, jwtService: JwtService) {
    /**
     * ゲームを開始して、JWTを取得する
     * @return JWT
     */
    def run(): String = {
        val weaponNames = weaponRepository.findAllWeaponNames()
        val weaponName = weaponNames(scala.util.Random.nextInt(weaponNames.length))
        jwtService.generateJwt(weaponName)
    }
  
}
