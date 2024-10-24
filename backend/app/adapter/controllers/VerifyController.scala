package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import play.api.mvc._
import play.api.libs.json.Json
import usecase.VerifyUseCase

/**
 * 答えを提出するコントローラー
 * @param cc コントローラーコンポーネント
 * @param useCase ユースケース
 */
@Singleton
class VerifyController @Inject()(cc: ControllerComponents, useCase: VerifyUseCase) extends AbstractController(cc) {

    /**
     * 答えを提出する
     * @param weaponName ブキ名
     * @return 結果
     */
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