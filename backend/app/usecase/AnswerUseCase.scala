package usecase

import javax.inject.{Inject, Singleton}
import domain.models.DenyList
import domain.models.WeaponTokenizer

/**
 * 答えのブキを取得するユースケース
 */
@Singleton
class AnswerUseCase() {
    /**
     * 答えのブキを取得する
     * @param weaponToken ブキトークン
     * @return 答えのブキ
     */
    def run(weaponToken: String): String = {
        if(!DenyList.contains(weaponToken)){
            DenyList.add(weaponToken)
        }
        WeaponTokenizer.decodeToken(weaponToken)
    }
}
