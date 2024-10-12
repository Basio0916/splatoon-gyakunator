package infrastructure.persistence.json

import domain.models._
import domain.repositories._
import play.api.libs.json._
import play.api.libs.functional.syntax._

class JsonWeaponRepository(
    source: scala.io.Source,
    mainWeaponRepository: MainWeaponRepository,
    subWeaponRepository: SubWeaponRepository,
    specialWeaponRepository: SpecialWeaponRepository
    ) extends WeaponRepository {

    private val json = Json.parse(source.mkString)

    private val weapons = json.as[List[JsValue]].map { weaponJson =>
        val name = (weaponJson \ "name").as[String]
        val mainWeaponName = (weaponJson \ "mainWeapon").as[String]
        val subWeaponName = (weaponJson \ "subWeapon").as[String]
        val specialWeaponName = (weaponJson \ "specialWeapon").as[String]
        val specialPoint = (weaponJson \ "specialPoint").as[String].toInt

        val mainWeapon = mainWeaponRepository.findMainWeaponByName(mainWeaponName).get
        val subWeapon = subWeaponRepository.findSubWeaponByName(subWeaponName).get
        val specialWeapon = specialWeaponRepository.findSpecialWeaponByName(specialWeaponName).get

        Weapon(name, mainWeapon, subWeapon, specialWeapon, specialPoint)
    }

    def findWeaponByName(name: String): Option[Weapon] = {
        weapons.find(_.name == name)
    }

    def findWeaponByRow(row: Int): Option[Weapon] = {
        weapons.lift(row)
    }

    def findAllWeaponNames(): List[String] = {
        weapons.map(_.name)
    }
}