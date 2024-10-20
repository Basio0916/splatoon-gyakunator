package usecase

import javax.inject.{Inject, Singleton}
import domain.services.JwtService

@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService){
    def run(jwt: String): String = {
        jwtService.decodeJwt(jwt)
    }
}
