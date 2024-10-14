package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import usecase.AnswerUseCase
import domain.models.AnswerInput

@Singleton
class AnswerController @Inject()(cc: ControllerComponents, answerUseCase: AnswerUseCase) extends AbstractController(cc) {

    def answer = Action { request =>
        request.body.asJson match{
            case Some(json) =>
                json.validate[AnswerInput].fold(
                    errors => BadRequest("Invalid json"),
                    answerInput => {
                        val result = answerUseCase.run(answerInput)
                        Ok(result.toString)
                    }
                )
            case None => BadRequest("Invalid json")
        }
    }
}