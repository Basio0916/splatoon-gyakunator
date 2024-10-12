package infrastructure.persistence.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import domain.models._
import domain.factories.SourceFactory

class JsonSpecialWeaponRepositorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "findSpecialWeaponByName" should "find special weapon by name" in {

        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.specialWeapons)
        }
        val repository = new JsonSpecialWeaponRepository(sourceFactory)
        val specialWeapon = repository.findSpecialWeaponByName("グレートバリア")
        specialWeapon.get.name should equal("グレートバリア")
        specialWeapon.get.hasZRButtonAction should equal(No)
        specialWeapon.get.hasRButtonAction should equal(No)
        specialWeapon.get.canOneShot should equal(No)
        specialWeapon.get.dealsContinuousDamage should equal(No)
        specialWeapon.get.isAttackType should equal(No)
        specialWeapon.get.jumpsToUsePoint should equal(Yes)
    }

    it should "return None if special weapon is not found" in {
        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.specialWeapons)
        }
        val repository = new JsonSpecialWeaponRepository(sourceFactory)
        val specialWeapon = repository.findSpecialWeaponByName("バブルランチャー")
        specialWeapon should equal(None)
    }
}