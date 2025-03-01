package usecase

import javax.inject.{Inject, Singleton}
import domain.services.JwtService
import domain.models.DenyList

/**
 * 答えのブキを取得するユースケース
 * @param jwtService JWTサービス
 * @param denyList 拒否リスト
 */
@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService, denyList: DenyList) {
    /**
     * 答えのブキを取得する
     * @param jwt JWT
     * @return 答えのブキ
     */
    def run(jwt: String): String = {
        if(!denyList.contains(jwt)){
            denyList.add(jwt)
        }
        jwtService.decodeJwt(jwt)
    }
}
