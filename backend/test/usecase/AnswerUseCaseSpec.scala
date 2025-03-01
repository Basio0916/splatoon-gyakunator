package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService
import domain.models.DenyList

class AnswerUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon names" in {
        val mockJwtService = mock[JwtService]
        val denyList = new DenyList()
        val weaponName = "わかばシューター"
        (mockJwtService.decodeJwt _).expects(*).returning(weaponName)
        val useCase = new AnswerUseCase(mockJwtService, denyList)
        useCase.run("token") should equal(weaponName)
    }

    it should "add the token to the blacklist" in {
        val mockJwtService = mock[JwtService]
        (mockJwtService.decodeJwt _).expects(*).returning("わかばシューター")
        val denyList = new DenyList()
        val useCase = new AnswerUseCase(mockJwtService, denyList)
        useCase.run("token")
        denyList.contains("token") should equal(true)
    }
}
