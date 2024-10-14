package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.GetAnswerWeaponNameUseCase
import play.api.libs.json.Json

class GetAnswerWeaponNameControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory{

  "GetAnswerWeaponNameController POST" should {

    "return 200" in {
      val mockUseCase = mock[GetAnswerWeaponNameUseCase]
      val weaponName = "わかばシューター"
      (mockUseCase.run _).expects(*).returning(weaponName)

      val controller = new GetAnswerWeaponNameController(stubControllerComponents(), mockUseCase)
      val result = controller.getAnswerWeaponName().apply(FakeRequest(POST, "/api/game/weaponname").withJsonBody(
        Json.obj(
          "jwt" -> "jwt-decoded-string"
        )
      ))

      status(result) mustBe OK
      contentAsJson(result) mustBe Json.obj("weaponName" -> weaponName)
    }

    "return 400 when JSON object validation fails" in {
      val mockUseCase = mock[GetAnswerWeaponNameUseCase]
      val controller = new GetAnswerWeaponNameController(stubControllerComponents(), mockUseCase)
      val request = FakeRequest(POST, "/api/game/weaponname").withJsonBody(Json.obj())
      val result = controller.getAnswerWeaponName().apply(request)
      status(result) mustBe BAD_REQUEST
    }

    "return 400 when JSON object is not send" in {
      val mockUseCase = mock[GetAnswerWeaponNameUseCase]
      val controller = new GetAnswerWeaponNameController(stubControllerComponents(), mockUseCase)
      val request = FakeRequest(POST, "/api/game/weaponname")
      val result = controller.getAnswerWeaponName().apply(request)
      status(result) mustBe BAD_REQUEST
    }
  }
}