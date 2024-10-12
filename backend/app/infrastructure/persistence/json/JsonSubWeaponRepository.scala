package infrastructure.persistence.json

import domain.models._
import domain.repositories.SubWeaponRepository
import domain.factories.SourceFactory
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._

class JsonSubWeaponRepository(sourceFactory: SourceFactory) extends SubWeaponRepository {
    private val source = sourceFactory.createSource
    private val json = Json.parse(source.mkString)

    private val subWeapons = json.as[List[SubWeapon]]

    def findSubWeaponByName(name: String): Option[SubWeapon] = {
        subWeapons.find(_.name == name)
    }
}