package domain.models

import play.api.libs.json._

case class GetAnswerWeaponNameInput(jwt: String)

object GetAnswerWeaponNameInput {
  implicit val reads: Reads[GetAnswerWeaponNameInput] = Json.reads[GetAnswerWeaponNameInput]
}