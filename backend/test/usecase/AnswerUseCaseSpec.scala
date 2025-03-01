package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.models.DenyList
import java.util.UUID

class AnswerUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon names" in {
        val weaponName = "わかばシューター"
        val useCase = new AnswerUseCase()
        val sessionId = UUID.randomUUID().toString()
        val token = s"${weaponName}_${sessionId}"
        useCase.run(token) should equal(weaponName)
    }

    it should "add the token to the blacklist" in {
        val useCase = new AnswerUseCase()
        useCase.run("token")
        DenyList.contains("token") should equal(true)
    }
}
