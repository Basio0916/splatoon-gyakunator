package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import play.api.libs.json.Json
import usecase.AnswerUseCase

/**
 * 答えのブキを返すコントローラー
 * @param cc コントローラーコンポーネント
 * @param answerUseCase ユースケース
 */
@Singleton
class AnswerController @Inject()(cc: ControllerComponents, answerUseCase: AnswerUseCase) extends AbstractController(cc) {

    /**
     * 答えのブキを返す
     * @return 答えのブキ
     */
    def answer = Action { request =>
        request.session.get("weaponToken") match {
            case Some(weaponToken) =>
                val answer = answerUseCase.run(weaponToken)
                Ok(Json.obj("weaponName" -> answer))
            case None => BadRequest("Token is required")
        }
    }
}