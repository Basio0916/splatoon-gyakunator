package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.AnswerUseCase
import domain.repositories.WeaponRepository
import play.api.libs.json.Json
import org.scalatest.prop.TableDrivenPropertyChecks

class AnswerControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory with TableDrivenPropertyChecks{
  
  "AnswerControllerSpec POST" should {

    "return 200" in {
      val mockAnswerUseCase = mock[AnswerUseCase]
      (mockAnswerUseCase.run _).expects(*).returning(true)
      val controller = new AnswerController(stubControllerComponents(), mockAnswerUseCase)
      val request = FakeRequest(POST, "/api/game/answer").withJsonBody(
        Json.obj(
          "jwt" -> "jwt-decoded-string",
          "weaponName" -> "わかばシューター"
        )
      )
      val result = controller.answer().apply(request)
      status(result) mustBe OK
      contentAsString(result) mustBe """{"result":true}"""
    }

    "return 400 when JSON object validation fails" in {
      val examples = Table(
        ("json"),
        (Json.obj("weaponName" -> "わかばシューター")),
        (Json.obj("jwt" -> "jwt-decoded-string")),
        (Json.obj())
      )

      forAll(examples) { json =>
        val mockAnswerUseCase = mock[AnswerUseCase]
        val controller = new AnswerController(stubControllerComponents(), mockAnswerUseCase)
        val request = FakeRequest(POST, "/api/game/answer").withJsonBody(json)
        val result = controller.answer().apply(request)
        status(result) mustBe BAD_REQUEST
      }
    }

    "return 400 when JSON object is not send" in {
      val mockAnswerUseCase = mock[AnswerUseCase]
      val controller = new AnswerController(stubControllerComponents(), mockAnswerUseCase)
      val request = FakeRequest(POST, "/api/game/answer")
      val result = controller.answer().apply(request)
      status(result) mustBe BAD_REQUEST
    }
  }
}