package usecase

import domain.models._
import domain.models.questions._
import domain.repositories._
import domain.services.JwtService
import play.api.libs.json._

class QuestionUseCase (weaponRepository: WeaponRepository, jwtService: JwtService) {
    def run(questionJsonString: String): Answer = {
        val questionJson = Json.parse(questionJsonString)
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