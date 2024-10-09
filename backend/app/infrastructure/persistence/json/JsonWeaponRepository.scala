package infrastructure.persistence.json

import domain.model._
import domain.repository.WeaponRepository
import play.api.libs.json._
import play.api.libs.functional.syntax._

class JsonWeaponRepository(source: scala.io.Source) extends WeaponRepository {

    private val mainWeaponRepository = new JsonMainWeaponRepository(source)
    private val subWeaponRepository = new JsonSubWeaponRepository(source)
    private val specialWeaponRepository = new JsonSpecialWeaponRepository(source)

    private val json = Json.parse(source.mkString)

    private implicit val weaponReads: Reads[Weapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "mainWeapon").read[String].map(name => mainWeaponRepository.findMainWeaponByName(name).get) and
        (JsPath \ "subWeapon").read[String].map(name => subWeaponRepository.findSubWeaponByName(name).get) and
        (JsPath \ "specialWeapon").read[String].map(name => specialWeaponRepository.findSpecialWeaponByName(name).get) and
        (JsPath \ "specialPoint").read[String].map(sp => sp.toInt)
    )(Weapon.apply _)

    private val weapons = (json \ "weapons").as[List[Weapon]]

    def findWeaponByName(name: String): Option[Weapon] = {
        weapons.find(_.name == name)
    }

    def findWeaponByRow(row: Int): Option[Weapon] = {
        Option(weapons(row))
    }

    def findAllWeaponNames(): List[String] = {
        weapons.map(_.name)
    }
}