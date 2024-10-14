package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.GetWeaponNamesUseCase
import play.api.libs.json.Json

class GetWeaponNamesControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory{

  "GetWeaponNamesController GET" should {

    "return weapon names" in {
      val mockUseCase = mock[GetWeaponNamesUseCase]
      val weaponNames = List("わかばシューター", "もみじシューター", "おちばシューター")
      (mockUseCase.run _).expects().returning(weaponNames)

      val controller = new GetWeaponNamesController(stubControllerComponents(), mockUseCase)
      val result = controller.getWeaponNames().apply(FakeRequest(GET, "/api/game/weaponname"))

      status(result) mustBe OK
      contentAsJson(result) mustBe Json.toJson(weaponNames)
    }
  }
}