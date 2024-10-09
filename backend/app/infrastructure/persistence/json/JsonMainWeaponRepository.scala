package infrastructure.persistence.json

import domain.model._
import domain.repository.MainWeaponRepository
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._

class JsonMainWeaponRepository(source: scala.io.Source) extends MainWeaponRepository {

    private val json = Json.parse(source.mkString)

    private val mainWeapons = (json \ "mainWeapons").as[List[MainWeapon]]

    def findMainWeaponByName(name: String): Option[MainWeapon] = {
        mainWeapons.find(_.name == name)
    }
}