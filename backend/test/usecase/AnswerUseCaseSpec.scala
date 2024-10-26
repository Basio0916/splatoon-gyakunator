package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService
import domain.services.BlackList

class AnswerUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon names" in {
        val mockJwtService = mock[JwtService]
        val blackList = new BlackList()
        val weaponName = "わかばシューター"
        (mockJwtService.decodeJwt _).expects(*).returning(weaponName)
        val useCase = new AnswerUseCase(mockJwtService, blackList)
        useCase.run("token") should equal(weaponName)
    }

    it should "add the token to the blacklist" in {
        val mockJwtService = mock[JwtService]
        (mockJwtService.decodeJwt _).expects(*).returning("わかばシューター")
        val blackList = new BlackList()
        val useCase = new AnswerUseCase(mockJwtService, blackList)
        useCase.run("token")
        blackList.contains("token") should equal(true)
    }
}
