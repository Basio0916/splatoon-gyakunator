package domain.models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class QuestionInput(jwt: String, questionName: String, option: Option[String], comparator: Option[String])

object QuestionInput {
  implicit val reads: Reads[QuestionInput] = (
    (JsPath \ "jwt").read[String] and
    (JsPath \ "questionName").read[String] and
    (JsPath \ "option").readNullable[String].map(_.filter(_.nonEmpty)) and
    (JsPath \ "comparator").readNullable[String].map(_.filter(_.nonEmpty))
  )(QuestionInput.apply _)
}