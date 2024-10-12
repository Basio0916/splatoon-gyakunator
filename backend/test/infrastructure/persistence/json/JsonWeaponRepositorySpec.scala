package infrastructure.persistence.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import domain.models._
import domain.factories.SourceFactory

class JsonWeaponRepositorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "findWeaponByName" should "find weapon by name" in {

        val mainWeaponSourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.mainWeapons)
        }
        val mainWeaponRepository = new JsonMainWeaponRepository(mainWeaponSourceFactory)
        val subWeaponSourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.subWeapons)
        }
        val subWeaponRepository = new JsonSubWeaponRepository(subWeaponSourceFactory)
        val specialWeaponSourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.specialWeapons)
        }
        val specialWeaponRepository = new JsonSpecialWeaponRepository(specialWeaponSourceFactory)
        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.weapons)
        }
        val weaponRepository = new JsonWeaponRepository(sourceFactory, mainWeaponRepository, subWeaponRepository, specialWeaponRepository)
        val weapon = weaponRepository.findWeaponByName("わかばシューター")
        weapon.get.name should equal("わかばシューター")
    }

    it should "return None if weapon is not found" in {
        val mainWeaponSourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.mainWeapons)
        }
        val mainWeaponRepository = new JsonMainWeaponRepository(mainWeaponSourceFactory)
        val subWeaponSourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.subWeapons)
        }
        val subWeaponRepository = new JsonSubWeaponRepository(subWeaponSourceFactory)
        val specialWeaponSourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.specialWeapons)
        }
        val specialWeaponRepository = new JsonSpecialWeaponRepository(specialWeaponSourceFactory)
        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.weapons)
        }
        val weaponRepository = new JsonWeaponRepository(sourceFactory, mainWeaponRepository, subWeaponRepository, specialWeaponRepository)
        val weapon = weaponRepository.findWeaponByName("リッター4K")
        weapon should equal(None)
    }
}