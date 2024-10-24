package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import usecase.QuestionUseCase
import play.api.libs.json.Json

/**
 * 質問に答えるコントローラー
 * @param cc コントローラーコンポーネント
 * @param useCase ユースケース
 */
@Singleton
class QuestionController @Inject()(cc: ControllerComponents, useCase: QuestionUseCase) extends AbstractController(cc) {

    /**
     * 質問に答える
     * @param questionName 質問名
     * @return 答え
     */
    def question(questionName: String) = Action { request =>
        val mayBeJwt = request.headers.get("X-Data-Token")

        mayBeJwt match {
            case Some(jwt) =>
                val option = request.getQueryString("option")
                val comparator = request.getQueryString("comparator")
                val answer = useCase.run(jwt, questionName, option, comparator)
                Ok(Json.obj("answer" -> answer.toString))
            case None => BadRequest("Token is required")
        }
    }
}