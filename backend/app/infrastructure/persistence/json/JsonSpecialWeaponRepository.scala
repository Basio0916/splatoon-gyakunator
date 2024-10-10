package infrastructure.persistence.json

import domain.model._
import domain.repository.SpecialWeaponRepository
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._

class JsonSpecialWeaponRepository(source: scala.io.Source) extends SpecialWeaponRepository {

    private val json = Json.parse(source.mkString)

    private val specialWeapons = json.as[List[SpecialWeapon]]

    def findSpecialWeaponByName(name: String): Option[SpecialWeapon] = {
        specialWeapons.find(_.name == name)
    }
}