package infrastructure.persistence.json

import domain.models._
import domain.repositories.MainWeaponRepository
import domain.factories.SourceFactory
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._

class JsonMainWeaponRepository(sourceFactory: SourceFactory) extends MainWeaponRepository {
    private val source = sourceFactory.createSource
    private val json = Json.parse(source.mkString)

    private val mainWeapons = json.as[List[MainWeapon]]

    def findMainWeaponByName(name: String): Option[MainWeapon] = {
        mainWeapons.find(_.name == name)
    }
}