package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService
import domain.models.Answer
import play.api.libs.json.Json

@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService) {
    def run(answerJsonString: String): Boolean = {
        val answerJson = Json.parse(answerJsonString)
        val jwt = (answerJson \ "jwt").as[String]
        val weaponName = (answerJson \ "weaponName").as[String]

        val decodedWeaponName = jwtService.decodeJwt(jwt)
        weaponName == decodedWeaponName
    }
}
