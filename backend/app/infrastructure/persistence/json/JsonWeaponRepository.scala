package infrastructure.persistence.json

import domain.models._
import domain.repositories._
import domain.factories.SourceFactory
import play.api.libs.json._
import play.api.libs.functional.syntax._
import javax.inject.{Inject, Singleton, Named}

/**
 * ブキのJSONリポジトリ
 */
@Singleton
class JsonWeaponRepository @Inject()(
    @Named("Weapon") sourceFactory: SourceFactory,
    mainWeaponRepository: MainWeaponRepository,
    subWeaponRepository: SubWeaponRepository,
    specialWeaponRepository: SpecialWeaponRepository
    ) extends WeaponRepository {
    private val source = sourceFactory.createSource
    private val json = Json.parse(source.mkString)
    source.close()

    private val weapons = json.as[List[JsValue]].map { weaponJson =>
        val name = (weaponJson \ "name").as[String]
        val mainWeaponName = (weaponJson \ "mainWeapon").as[String]
        val subWeaponName = (weaponJson \ "subWeapon").as[String]
        val specialWeaponName = (weaponJson \ "specialWeapon").as[String]
        val specialPoint = (weaponJson \ "specialPoint").as[String].toInt

        val mainWeapon = mainWeaponRepository.findMainWeaponByName(mainWeaponName).getOrElse(throw new Exception(s"$mainWeaponName is not found"))
        val subWeapon = subWeaponRepository.findSubWeaponByName(subWeaponName).getOrElse(throw new Exception(s"$subWeaponName is not found"))
        val specialWeapon = specialWeaponRepository.findSpecialWeaponByName(specialWeaponName).getOrElse(throw new Exception(s"$specialWeaponName is not found"))

        Weapon(name, mainWeapon, subWeapon, specialWeapon, specialPoint)
    }

    def findWeaponByName(name: String): Option[Weapon] = {
        weapons.find(_.name == name)
    }

    def findWeaponByRow(row: Int): Option[Weapon] = {
        weapons.lift(row)
    }

    def findAllWeaponNames(): Seq[String] = {
        weapons.map(_.name)
    }
}