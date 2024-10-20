package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.AnswerUseCase
import play.api.libs.json.Json

class AnswerControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory{

  "AnswerController GET" should {

    "return 200" in {
      val mockUseCase = mock[AnswerUseCase]
      val weaponName = "わかばシューター"
      (mockUseCase.run _).expects(*).returning(weaponName)

      val controller = new AnswerController(stubControllerComponents(), mockUseCase)
      val request =  FakeRequest(GET, "/api/answer").withHeaders("X-Data-Token" -> "jwt-decoded-string")
      val result = controller.answer().apply(request)

      status(result) mustBe OK
      contentAsJson(result) mustBe Json.obj("weaponName" -> weaponName)
    }

    "return 400 when X-Data-Token is not set" in {
      val mockUseCase = mock[AnswerUseCase]
      val controller = new AnswerController(stubControllerComponents(), mockUseCase)
      val request = FakeRequest(GET, "/api/answer")
      val result = controller.answer().apply(request)
      status(result) mustBe BAD_REQUEST
    }
  }
}