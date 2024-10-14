package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService
import domain.models.AnswerInput

class AnswerUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {

    "run" should "return the correct answer" in {
        
        val examples = Table(
            ("weaponName", "expected"),
            ("わかばシューター", true),
            ("もみじシューター", false),
            ("プロモデラーMG", false)
        )

        val mockJwtService = mock[JwtService]
        (mockJwtService.decodeJwt _).stubs("わかばシューター").returning("わかばシューター")

        forAll(examples) { (weaponName, expected) =>
            
            var answerInput = new AnswerInput("わかばシューター", weaponName)

            val useCase = new AnswerUseCase(mockJwtService)
            val result = useCase.run(answerInput) 
            result should equal(expected)
        }
    }  
}
