package usecase

import javax.inject.{Inject, Singleton}
import domain.models.DenyList
import domain.models.WeaponTokenizer

/**
 * 答えのブキを取得するユースケース
 * @param denyList 拒否リスト
 */
@Singleton
class AnswerUseCase @Inject()(denyList: DenyList) {
    /**
     * 答えのブキを取得する
     * @param weaponToken ブキトークン
     * @return 答えのブキ
     */
    def run(weaponToken: String): String = {
        if(!denyList.contains(weaponToken)){
            denyList.add(weaponToken)
        }
        WeaponTokenizer.decodeToken(weaponToken)
    }
}
