package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.services.JwtService
import domain.models.DenyList

class AnswerUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon names" in {
        val denyList = new DenyList()
        val weaponName = "わかばシューター"
        val useCase = new AnswerUseCase(denyList)
        useCase.run("token") should equal(weaponName)
    }

    it should "add the token to the blacklist" in {
        val denyList = new DenyList()
        val useCase = new AnswerUseCase(denyList)
        useCase.run("token")
        denyList.contains("token") should equal(true)
    }
}
