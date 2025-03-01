package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService
import domain.models.WeaponTokenizer

/**
 * ゲーム開始ユースケース
 * @param weaponRepository ブキリポジトリ
 */
@Singleton
class GameStartUseCase @Inject()(weaponRepository: WeaponRepository) {
    /**
     * ゲームを開始して、ブキトークンを取得する
     * @return ブキトークン
     */
    def run(): String = {
        val weaponNames = weaponRepository.findAllWeaponNames()
        val weaponName = weaponNames(scala.util.Random.nextInt(weaponNames.length))
        val sessionId = java.util.UUID.randomUUID().toString
        WeaponTokenizer.createToken(weaponName, sessionId)
    }
  
}
