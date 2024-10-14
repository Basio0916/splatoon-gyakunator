package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import usecase.QuestionUseCase
import domain.models.QuestionInput

@Singleton
class QuestionController @Inject()(cc: ControllerComponents, questionUseCase: QuestionUseCase) extends AbstractController(cc) {

    def question = Action { request =>
        request.body.asJson match{
            case Some(json) =>
                json.validate[QuestionInput].fold(
                    errors => BadRequest("Invalid json"),
                    questionInput => {
                        val result = questionUseCase.run(questionInput)
                        Ok(result.toString)
                    }
                )
            case None => BadRequest("Invalid json")
        }
    }
}