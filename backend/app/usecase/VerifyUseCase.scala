package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService

/**
 * 答えを提出するユースケース
 * @param jwtService JWTサービス
 */
@Singleton
class VerifyUseCase @Inject()(jwtService: JwtService) {
    /**
     * 答えを提出する
     * @param jwt JWT
     * @param weaponName ブキ名
     * @return 結果
     */
    def run(jwt: String, weaponName: String): Boolean = {

        val decodedWeaponName = jwtService.decodeJwt(jwt)
        weaponName == decodedWeaponName
    }
}
