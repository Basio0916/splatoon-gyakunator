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

class QuestionControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory with TableDrivenPropertyChecks{
  
  "QuestionController POST" should {

    "return 200" in {
      val examples = Table(
        ("json"),
        (Json.obj("jwt" -> "jwt-decoded-string", "questionName" -> "MainWeaponMaxValue", "option" -> "25.0", "comparator" -> "以上？")),
        (Json.obj("jwt" -> "jwt-decoded-string", "questionName" -> "MainWeaponName", "option" -> "わかばシューター？", "comparator" -> "")),
        (Json.obj("jwt" -> "jwt-decoded-string", "questionName" -> "IsExplosive", "option" -> "", "comparator" -> ""))
      )
      
      forAll(examples) { json =>
        val mockQuestionUseCase = mock[QuestionUseCase]
        (mockQuestionUseCase.run _).expects(*).returning(Yes)
        val controller = new QuestionController(stubControllerComponents(), mockQuestionUseCase)
        val request = FakeRequest(POST, "/api/game/question").withJsonBody(json)
        val result = controller.answer().apply(request)
        status(result) mustBe OK
      }
    }

    "return 400 when JSON object validation fails" in {
      val examples = Table(
        ("json"),
        (Json.obj("questionName" -> "MainWeaponMaxValue", "option" -> "25.0", "comparator" -> "以上？")),
        (Json.obj("jwt" -> "jwt-decoded-string", "option" -> "25.0", "comparator" -> "以上？")),
        (Json.obj()),
      )

      forAll(examples) {json =>
        val mockQuestionUseCase = mock[QuestionUseCase]
        val controller = new QuestionController(stubControllerComponents(), mockQuestionUseCase)
        val request = FakeRequest(POST, "/api/game/question").withJsonBody(json)
        val result = controller.answer().apply(request)
        status(result) mustBe BAD_REQUEST
      }
    }

    "return 400 when JSON object is not send" in {
      val mockQuestionUseCase = mock[QuestionUseCase]
      val controller = new QuestionController(stubControllerComponents(), mockQuestionUseCase)
      val request = FakeRequest(POST, "/api/game/question")
      val result = controller.answer().apply(request)
      status(result) mustBe BAD_REQUEST
    }
  }
}