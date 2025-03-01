package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.models.DenyList
import domain.exceptions.InvalidTokenException
import domain.models.WeaponTokenizer

/**
 * 答えを提出するユースケース
 */
@Singleton
class VerifyUseCase() {
    /**
     * 答えを提出する
     * @param weaponName ブキ名
     * @return 結果
     */
    def run(weaponToken: String, weaponName: String): Boolean = {

        if(DenyList.contains(weaponToken)){
            throw new InvalidTokenException()
        }
        val decodedWeaponName = WeaponTokenizer.decodeToken(weaponToken)
        weaponName == decodedWeaponName
    }
}
