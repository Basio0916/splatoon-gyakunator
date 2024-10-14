package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import usecase.GameStartUseCase
import play.api.mvc._

@Singleton
class GameStartController @Inject()(cc: ControllerComponents, gameStartUseCase: GameStartUseCase) extends AbstractController(cc) {

    def startGame = Action {
        val jwt = gameStartUseCase.run()
        Ok(jwt)
    }
}