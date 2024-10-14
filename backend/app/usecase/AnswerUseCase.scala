package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService
import domain.models.Answer
import domain.models.AnswerInput

@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService) {
    def run(answerInput: AnswerInput): Boolean = {

        val decodedWeaponName = jwtService.decodeJwt(answerInput.jwt)
        answerInput.weaponName == decodedWeaponName
    }
}
