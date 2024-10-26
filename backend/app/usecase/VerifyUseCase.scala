package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService
import domain.services.BlackList
import domain.exceptions.InvalidTokenException

/**
 * 答えを提出するユースケース
 * @param jwtService JWTサービス
 * @param blackList ブラックリスト
 */
@Singleton
class VerifyUseCase @Inject()(jwtService: JwtService, blackList: BlackList) {
    /**
     * 答えを提出する
     * @param jwt JWT
     * @param weaponName ブキ名
     * @return 結果
     */
    def run(jwt: String, weaponName: String): Boolean = {

        if(blackList.contains(jwt)){
            throw new InvalidTokenException()
        }
        val decodedWeaponName = jwtService.decodeJwt(jwt)
        weaponName == decodedWeaponName
    }
}
