package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService
import domain.models.GetAnswerWeaponNameInput

class GetAnswerWeaponNameUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon names" in {
        var mockJwtService = mock[JwtService]
        var weaponName = "わかばシューター"
        (mockJwtService.decodeJwt _).expects(*).returning(weaponName)
        var useCase = new GetAnswerWeaponNameUseCase(mockJwtService)
        var input = new GetAnswerWeaponNameInput("token")
        useCase.run(input) should equal(weaponName)
    }
}
