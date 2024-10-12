package infrastructure.persistence.json

import domain.models._
import domain.repositories.SpecialWeaponRepository
import domain.factories.SourceFactory
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._

class JsonSpecialWeaponRepository(sourceFactory: SourceFactory) extends SpecialWeaponRepository {
    private val source = sourceFactory.createSource
    private val json = Json.parse(source.mkString)

    private val specialWeapons = json.as[List[SpecialWeapon]]

    def findSpecialWeaponByName(name: String): Option[SpecialWeapon] = {
        specialWeapons.find(_.name == name)
    }
}