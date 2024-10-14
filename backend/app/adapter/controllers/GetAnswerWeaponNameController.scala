package adapter.controllers

import javax.inject._
import play.api.mvc.Results._
import usecase.GetAnswerWeaponNameUseCase
import play.api.mvc._
import play.api.libs.json.Json
import domain.models.GetAnswerWeaponNameInput

@Singleton
class GetAnswerWeaponNameController @Inject()(cc: ControllerComponents, getAnswerWeaponNameUseCase: GetAnswerWeaponNameUseCase) extends AbstractController(cc) {

    def getAnswerWeaponName = Action { request =>
        request.body.asJson match{
            case Some(json) =>
                json.validate[GetAnswerWeaponNameInput].fold(
                    errors => BadRequest("Invalid json"),
                    input => {
                        val weaponName = getAnswerWeaponNameUseCase.run(input)
                        Ok(Json.obj("weaponName" -> weaponName))
                    }
                )
            case None => BadRequest("Invalid json")
        }
    }
}