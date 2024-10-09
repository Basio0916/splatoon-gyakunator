package infrastructure.persistence.json

import domain.model._
import domain.repository.MainWeaponRepository
import play.api.libs.json._
import play.api.libs.functional.syntax._

class JsonMainWeaponRepository(source: scala.io.Source) extends MainWeaponRepository {

    private val json = Json.parse(source.mkString)

    private implicit val mainWeaponReads: Reads[MainWeapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "weaponCategory").read[WeaponCategory] and
        ((JsPath \ "range1").read[String] and (JsPath \ "range2").read[String]).tupled.map { case (r1, r2) => 
            List(r1, r2).flatMap(r => if (r.isEmpty) None else Some(r.toDouble))
        } and
        ((JsPath \ "damage1").read[String] and (JsPath \ "damage2").read[String] and (JsPath \ "damage3").read[String] and (JsPath \ "damage4").read[String]).tupled.map { case (d1, d2, d3, d4) => 
            List(d1, d2, d3, d4).flatMap(d => if (d.isEmpty) None else Some(d.toDouble))
        } and
        ((JsPath \ "firingInterval1").read[String] and (JsPath \ "firingInterval2").read[String]).tupled.map { case (fi1, fi2) => 
            List(fi1, fi2).flatMap(fi => if (fi.isEmpty) None else Some(fi.toDouble))
        } and
        ((JsPath \ "spread1").read[String] and (JsPath \ "spread2").read[String]).tupled.map { case (s1, s2) => 
            List(s1, s2).flatMap(s => if (s.isEmpty) None else Some(s.toDouble))
        } and
        (JsPath \ "weight").read[Weight] and
        (JsPath \ "canRapidFire").read[Answer] and
        (JsPath \ "canCharge").read[Answer] and
        (JsPath \ "isExplosive").read[Answer] and
        (JsPath \ "canRollingOrBrushing").read[Answer] and
        (JsPath \ "canChargeKeep").read[Answer] and
        (JsPath \ "dodgeRollCount").read[String].map(ic => ic.toInt) and
        (JsPath \ "hasDirectHitSound").read[Answer]
    )(MainWeapon.apply _)

    private val mainWeapons = (json \ "mainWeapons").as[List[MainWeapon]]

    def findMainWeaponByName(name: String): Option[MainWeapon] = {
        mainWeapons.find(_.name == name)
    }
}