package usecase

import javax.inject.{Inject, Singleton}
import domain.services.JwtService
import domain.services.BlackList

/**
 * 答えのブキを取得するユースケース
 * @param jwtService JWTサービス
 * @param blackList ブラックリスト
 */
@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService, blackList: BlackList) {
    /**
     * 答えのブキを取得する
     * @param jwt JWT
     * @return 答えのブキ
     */
    def run(jwt: String): String = {
        if(!blackList.contains(jwt)){
            blackList.add(jwt)
        }
        jwtService.decodeJwt(jwt)
    }
}
