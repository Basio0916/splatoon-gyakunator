package usecase

import javax.inject.{Inject, Singleton}
import domain.models._
import domain.models.questions._
import domain.repositories._
import domain.services.JwtService
import domain.models.QuestionInput

@Singleton
class QuestionUseCase @Inject()(weaponRepository: WeaponRepository, jwtService: JwtService) {
    def run(questionInput: QuestionInput): Answer = {
        val QuestionInput(jwt, questionName, option, comparator) = questionInput

        val weaponName = jwtService.decodeJwt(jwt);
        val answerWeapon = weaponRepository.findWeaponByName(weaponName).getOrElse(throw new IllegalArgumentException("Invalid token"))
        
        val question = Question(questionName, answerWeapon, option, comparator)
        question.answer
    }
}