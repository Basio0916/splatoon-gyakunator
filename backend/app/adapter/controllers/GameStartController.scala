package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import usecase.GameStartUseCase
import play.api.mvc._
import play.api.libs.json.Json

/**
 * ゲーム開始コントローラー
 * @param cc コントローラーコンポーネント
 * @param useCase ユースケース
 */
@Singleton
class GameStartController @Inject()(cc: ControllerComponents, useCase: GameStartUseCase) extends AbstractController(cc) {

    /**
     * ゲームを開始して、JWTを取得する
     * @return JWT
     */
    def startGame = Action {
        val jwt = useCase.run()
        Ok(Json.obj("jwt" -> jwt))
    }
}