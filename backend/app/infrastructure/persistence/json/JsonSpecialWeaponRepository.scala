package infrastructure.persistence.json

import domain.model._
import domain.repository.SpecialWeaponRepository
import play.api.libs.json._
import play.api.libs.functional.syntax._

class JsonSpecialWeaponRepository(source: scala.io.Source) extends SpecialWeaponRepository {

    private val json = Json.parse(source.mkString)

    private implicit val specialWeaponReads: Reads[SpecialWeapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "hasZRButtonAction").read[Answer] and
        (JsPath \ "hasRButtonAction").read[Answer] and
        (JsPath \ "canOneShot").read[Answer] and
        (JsPath \ "dealsContinuousDamage").read[Answer] and
        (JsPath \ "isAttackType").read[Answer] and
        (JsPath \ "jumpsToUsePoint").read[Answer]
    )(SpecialWeapon.apply _)

    private val specialWeapons = (json \ "specialWeapons").as[List[SpecialWeapon]]

    def findSpecialWeaponByName(name: String): Option[SpecialWeapon] = {
        specialWeapons.find(_.name == name)
    }
}