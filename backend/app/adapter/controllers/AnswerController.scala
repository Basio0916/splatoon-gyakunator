package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import play.api.libs.json.Json
import usecase.AnswerUseCase

@Singleton
class AnswerController @Inject()(cc: ControllerComponents, useCase: AnswerUseCase) extends AbstractController(cc) {

    def answer = Action { request =>
        val mayBeJwt = request.headers.get("X-Data-Token")
        
        mayBeJwt match {
            case Some(jwt) =>
                val weaponName = useCase.run(jwt)
                Ok(Json.obj("weaponName" -> weaponName))
            case None => BadRequest("Token is required")
        }
    }
}