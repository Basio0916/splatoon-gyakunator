package infrastructure.persistence.json

import domain.models._
import domain.repositories.MainWeaponRepository
import domain.factories.SourceFactory
import play.api.libs.json._
import infrastructure.persistence.json.JsonReaders._
import javax.inject.{Inject, Singleton, Named}

@Singleton
class JsonMainWeaponRepository @Inject()(@Named("MainWeapon") sourceFactory: SourceFactory) extends MainWeaponRepository {
    private val source = sourceFactory.createSource
    private val json = Json.parse(source.mkString)
    source.close()

    private val mainWeapons = json.as[List[MainWeapon]]

    def findMainWeaponByName(name: String): Option[MainWeapon] = {
        mainWeapons.find(_.name == name)
    }
}