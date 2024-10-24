package usecase

import javax.inject.{Inject, Singleton}
import domain.services.JwtService

/**
 * 答えのブキを取得するユースケース
 * @param jwtService JWTサービス
 */
@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService){
    /**
     * 答えのブキを取得する
     * @param jwt JWT
     * @return 答えのブキ
     */
    def run(jwt: String): String = {
        jwtService.decodeJwt(jwt)
    }
}
