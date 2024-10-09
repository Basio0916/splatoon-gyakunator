package infrastructure.persistence.json

import domain.model._
import domain.repository.SubWeaponRepository
import play.api.libs.json._
import play.api.libs.functional.syntax._

class JsonSubWeaponRepository(source: scala.io.Source) extends SubWeaponRepository {

    private val json = Json.parse(source.mkString)

    private implicit val subWeaponReads: Reads[SubWeapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "inkConsumption").read[String].map(ic => ic.toInt) and
        ((JsPath \ "damage1").read[String] and (JsPath \ "damage2").read[String] and (JsPath \ "damage3").read[String]).tupled.map { case (d1, d2, d3) => 
            List(d1, d2, d3).flatMap(d => if (d.isEmpty) None else Some(d.toDouble))
        } and
        (JsPath \ "isAttackType").read[Answer] and
        (JsPath \ "canBePlaced").read[Answer] and
        (JsPath \ "canInk").read[Answer] and
        (JsPath \ "canMark").read[Answer]
    )(SubWeapon.apply _)

    private val subWeapons = (json \ "subWeapons").as[List[SubWeapon]]

    def findSubWeaponByName(name: String): Option[SubWeapon] = {
        subWeapons.find(_.name == name)
    }
}