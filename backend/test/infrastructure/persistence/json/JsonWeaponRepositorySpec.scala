package infrastructure.persistence.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import domain.models._

class JsonWeaponRepositorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "findWeaponByName" should "find weapon by name" in {

        val mainWeaponSource = Source.fromString(JsonData.mainWeapons)
        val mainWeaponRepository = new JsonMainWeaponRepository(mainWeaponSource)
        val subWeaponSource = Source.fromString(JsonData.subWeapons)
        val subWeaponRepository = new JsonSubWeaponRepository(subWeaponSource)
        val specialWeaponSource = Source.fromString(JsonData.specialWeapons)
        val specialWeaponRepository = new JsonSpecialWeaponRepository(specialWeaponSource)
        val source = Source.fromString(JsonData.weapons)
        val weaponRepository = new JsonWeaponRepository(source, mainWeaponRepository, subWeaponRepository, specialWeaponRepository)
        val weapon = weaponRepository.findWeaponByName("わかばシューター")
        weapon.get.name should equal("わかばシューター")
    }

    it should "return None if weapon is not found" in {
        val mainWeaponSource = Source.fromString(JsonData.mainWeapons)
        val mainWeaponRepository = new JsonMainWeaponRepository(mainWeaponSource)
        val subWeaponSource = Source.fromString(JsonData.subWeapons)
        val subWeaponRepository = new JsonSubWeaponRepository(subWeaponSource)
        val specialWeaponSource = Source.fromString(JsonData.specialWeapons)
        val specialWeaponRepository = new JsonSpecialWeaponRepository(specialWeaponSource)
        val source = Source.fromString(JsonData.weapons)
        val weaponRepository = new JsonWeaponRepository(source, mainWeaponRepository, subWeaponRepository, specialWeaponRepository)
        val weapon = weaponRepository.findWeaponByName("リッター4K")
        weapon should equal(None)
    }
}