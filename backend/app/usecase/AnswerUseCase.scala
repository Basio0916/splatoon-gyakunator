package usecase

import javax.inject.{Inject, Singleton}
import domain.repositories.WeaponRepository
import domain.services.JwtService
import domain.models.Answer
import play.api.libs.json.Json
import play.api.libs.json.JsValue

@Singleton
class AnswerUseCase @Inject()(jwtService: JwtService) {
    def run(answerJson: JsValue): Boolean = {
        val jwt = (answerJson \ "jwt").as[String]
        val weaponName = (answerJson \ "weaponName").as[String]

        val decodedWeaponName = jwtService.decodeJwt(jwt)
        weaponName == decodedWeaponName
    }
}
