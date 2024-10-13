package infrastructure.persistence.json

import domain.models._
import domain.repositories.SpecialWeaponRepository
import domain.factories.SourceFactory
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._
import javax.inject.{Inject, Singleton, Named}

@Singleton
class JsonSpecialWeaponRepository @Inject()(@Named("SpecialWeapon") sourceFactory: SourceFactory) extends SpecialWeaponRepository {
    private val source = sourceFactory.createSource
    private val json = Json.parse(source.mkString)
    source.close()

    private val specialWeapons = json.as[List[SpecialWeapon]]

    def findSpecialWeaponByName(name: String): Option[SpecialWeapon] = {
        specialWeapons.find(_.name == name)
    }
}