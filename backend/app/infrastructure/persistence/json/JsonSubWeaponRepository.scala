package infrastructure.persistence.json

import domain.model._
import domain.repository.SubWeaponRepository
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._

class JsonSubWeaponRepository(source: scala.io.Source) extends SubWeaponRepository {

    private val json = Json.parse(source.mkString)

    private val subWeapons = json.as[List[SubWeapon]]

    def findSubWeaponByName(name: String): Option[SubWeapon] = {
        subWeapons.find(_.name == name)
    }
}