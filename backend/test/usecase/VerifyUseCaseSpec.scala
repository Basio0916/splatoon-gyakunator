package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService
import domain.services.BlackList
import domain.exceptions.InvalidTokenException

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
        val blackList = new BlackList()
        forAll(examples) { (weaponName, expected) =>
            val useCase = new VerifyUseCase(mockJwtService, blackList)
            val result = useCase.run("わかばシューター", weaponName) 
            result should equal(expected)
        }
    } 

    it should "throws an exception when the token is contained in the blacklist" in {
        val mockJwtService = mock[JwtService]
        val blackList = new BlackList()
        blackList.add("token")
        val useCase = new VerifyUseCase(mockJwtService, blackList)
        val weaponName = "わかばシューター"
        val thrown = intercept[InvalidTokenException] {
            useCase.run("token", weaponName)
        }
        thrown.getMessage should equal("Invalid token")
    }
}
