package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService

class VerifyUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {

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
            val useCase = new VerifyUseCase(mockJwtService)
            val result = useCase.run("わかばシューター", weaponName) 
            result should equal(expected)
        }
    }  
}
