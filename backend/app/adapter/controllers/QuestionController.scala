package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import usecase.QuestionUseCase
import play.api.libs.json.Json

@Singleton
class QuestionController @Inject()(cc: ControllerComponents, questionUseCase: QuestionUseCase) extends AbstractController(cc) {

    def question(questionName: String) = Action { request =>
        val mayBeJwt = request.headers.get("X-Data-Token")

        mayBeJwt match {
            case Some(jwt) =>
                val option = request.getQueryString("option")
                val comparator = request.getQueryString("comparator")
                val answer = questionUseCase.run(jwt, questionName, option, comparator)
                Ok(Json.obj("answer" -> answer.toString))
            case None => BadRequest("Token is required")
        }
    }
}