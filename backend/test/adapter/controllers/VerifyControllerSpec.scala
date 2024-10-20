package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.VerifyUseCase
import domain.repositories.WeaponRepository
import play.api.libs.json.Json
import org.scalatest.prop.TableDrivenPropertyChecks

class VerifyControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory with TableDrivenPropertyChecks{
  
  "VerifyControllerSpec GET" should {

    "return 200" in {
      val mockUseCase = mock[VerifyUseCase]
      (mockUseCase.run _).expects(*, *).returning(true)
      val controller = new VerifyController(stubControllerComponents(), mockUseCase)
      val weaponName = "わかばシューター"
      val encodedWeaponName = java.net.URLEncoder.encode(weaponName, "UTF-8")
      val request = FakeRequest(GET, s"/api/verify/$encodedWeaponName").withHeaders("X-Data-Token" -> "jwt-decoded-string")
      val result = controller.verify("わかばシューター").apply(request)
      status(result) mustBe OK
      contentAsJson(result) mustBe Json.obj("result" -> true)
    }

    "return 400 when X-Data-Token is not set" in {
      val mockUseCase = mock[VerifyUseCase]
      (mockUseCase.run _).stubs(*, *).returning(true)
      val controller = new VerifyController(stubControllerComponents(), mockUseCase)
      val request = FakeRequest(GET, "/api/verify/わかばシューター")
      val result = controller.verify("わかばシューター").apply(request)
      status(result) mustBe BAD_REQUEST
    }
  }
}