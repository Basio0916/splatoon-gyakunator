package adapter.controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalamock.scalatest.MockFactory
import usecase.GameStartUseCase

class GameStartControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory{

  "GameStartController GET" should {

    "return a JWT token" in {
      val mockUseCase = mock[GameStartUseCase]
      (mockUseCase.run _).expects().returning("testToken")

      val controller = new GameStartController(stubControllerComponents(), mockUseCase)
      val result = controller.startGame().apply(FakeRequest(GET, "/api/game/start"))

      status(result) mustBe OK
      contentAsString(result) mustBe ("""{"jwt":"testToken"}""")
    }
  }
}