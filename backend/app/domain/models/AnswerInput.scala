package domain.models

import play.api.libs.json._

case class AnswerInput(jwt: String, weaponName: String)

object AnswerInput {
  implicit val reads: Reads[AnswerInput] = Json.reads[AnswerInput]
}