package usecase

import javax.inject.{Inject, Singleton}
import domain.models._
import domain.models.questions._
import domain.repositories._
import domain.services.JwtService
import play.api.libs.json._

@Singleton
class QuestionUseCase @Inject()(weaponRepository: WeaponRepository, jwtService: JwtService) {
    def run(questionJson: JsValue): Answer = {
        val jwt = (questionJson \ "jwt").as[String]
        val questionName = (questionJson \ "questionName").as[String]
        val option = (questionJson \ "option").asOpt[String]
        val comparator = (questionJson \ "comparator").asOpt[String]

        val weaponName = jwtService.decodeJwt(jwt);
        val answerWeapon = weaponRepository.findWeaponByName(weaponName).getOrElse(throw new IllegalArgumentException("Invalid token"))
        
        val question = Question(questionName, answerWeapon, option, comparator)
        question.answer
    }
}