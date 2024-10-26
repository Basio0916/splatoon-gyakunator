package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.QuestionUseCase
import play.api.libs.json.Json
import org.scalatest.prop.TableDrivenPropertyChecks
import domain.models._
import domain.exceptions.InvalidTokenException

class QuestionControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory with TableDrivenPropertyChecks {
  
  "QuestionController GET" should {

    "return 200" in {
      val examples = Table(
        ("jwt", "questionName", "option", "comparator"),
        ("jwt-decoded-string", "MainWeaponMaxDamageQuestion", Some("25.0"), Some("以上？")),
        ("jwt-decoded-string", "MainWeaponNameQuestion", Some("わかばシューター？"), None),
        ("jwt-decoded-string", "IsExplosiveQuestion", None, None)
      )
      
      forAll(examples) { (jwt, questionName, option, comparator) =>
        val mockUseCase = mock[QuestionUseCase]
        (mockUseCase.run _).expects(*, *, *, *).returning(Yes)
        val controller = new QuestionController(stubControllerComponents(), mockUseCase)
        val queryString = Seq(
          option.map("option" -> _),
          comparator.map("comparator" -> _)
        ).flatten.toMap
        var url = s"/api/question/$questionName?${queryString.map { case (key, value) => s"$key=$value" }.mkString("&")}"
        var request = FakeRequest(GET, url).withHeaders("X-Data-Token" -> jwt)
        val result = controller.question(questionName).apply(request)
        status(result) mustBe OK
      }
    }

    "return 400 when X-Data-Token is not set" in {
      val mockUseCase = mock[QuestionUseCase]
      (mockUseCase.run _).stubs(*, *, *, *).returning(Yes)
      val controller = new QuestionController(stubControllerComponents(), mockUseCase)
      val request = FakeRequest(GET, "/api/question/MainWeaponMaxDamageQuestion?option=25&comparator=以上？")
      val result = controller.question("MainWeaponMaxDamageQuestion").apply(request)
      status(result) mustBe BAD_REQUEST
    }

    "return 400 when invalid token" in {
      val mockUseCase = mock[QuestionUseCase]
      (mockUseCase.run _).stubs(*, *, *, *).throwing(new InvalidTokenException)
      val controller = new QuestionController(stubControllerComponents(), mockUseCase)
      val request = FakeRequest(GET, "/api/question/MainWeaponMaxDamageQuestion?option=25&comparator=以上？").withHeaders("X-Data-Token" -> "invalid-token")
      val result = controller.question("MainWeaponMaxDamageQuestion").apply(request)
      status(result) mustBe BAD_REQUEST
    }
  }
}