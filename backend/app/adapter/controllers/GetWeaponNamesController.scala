package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import usecase.GetWeaponNamesUseCase
import play.api.mvc._
import play.api.libs.json.Json

@Singleton
class GetWeaponNamesController @Inject()(cc: ControllerComponents, getWeaponNamesUseCase: GetWeaponNamesUseCase) extends AbstractController(cc) {

    def getWeaponNames = Action {
        val weaponNames = getWeaponNamesUseCase.run()
        Ok(Json.toJson(weaponNames))
    }
}