package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import play.api.libs.json.Json
import usecase.VerifyUseCase

@Singleton
class VerifyController @Inject()(cc: ControllerComponents, useCase: VerifyUseCase) extends AbstractController(cc) {

    def verify(weaponName: String) = Action { request =>
        val mayBeJwt = request.headers.get("X-Data-Token")

        mayBeJwt match {
            case Some(jwt) =>
                val result = useCase.run(jwt, weaponName)
                Ok(Json.obj("result" -> result))
            case None => BadRequest("Token is required")
        }
    }
}