package usecase

import javax.inject.{Inject, Singleton}
import domain.services.JwtService
import domain.models.GetAnswerWeaponNameInput

@Singleton
class GetAnswerWeaponNameUseCase @Inject()(jwtService: JwtService){
    def run(input: GetAnswerWeaponNameInput): String = {
        jwtService.decodeJwt(input.jwt)
    }
}
