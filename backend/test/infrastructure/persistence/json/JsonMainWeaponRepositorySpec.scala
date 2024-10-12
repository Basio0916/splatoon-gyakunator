package infrastructure.persistence.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import domain.models._
import domain.factories.SourceFactory

class JsonMainWeaponRepositorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "findMainWeaponByName" should "find main weapon by name" in {

        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.mainWeapons)
        }
        val repository = new JsonMainWeaponRepository(sourceFactory)
        val mainWeapon = repository.findMainWeaponByName("わかばシューター")
        mainWeapon.get.name should equal("わかばシューター")
        mainWeapon.get.weaponCategory should equal(Shooter)
        mainWeapon.get.range should equal(List(1.6))
        mainWeapon.get.damage should equal(List(28.0))
        mainWeapon.get.firingInterval should equal(List(5.0))
        mainWeapon.get.spread should equal(List(12.0))
        mainWeapon.get.weight should equal(Light)
        mainWeapon.get.canRapidFire should equal(Yes)
        mainWeapon.get.canCharge should equal(No)
        mainWeapon.get.isExplosive should equal(No)
        mainWeapon.get.canRollingOrBrushing should equal(No)
        mainWeapon.get.canChargeKeep should equal(No)
        mainWeapon.get.dodgeRollCount should equal(0)
        mainWeapon.get.hasDirectHitSound should equal(No)
    }

    it should "return None if main weapon is not found" in {
        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.mainWeapons)
        }
        val repository = new JsonMainWeaponRepository(sourceFactory)
        val mainWeapon = repository.findMainWeaponByName("リッター4K")
        mainWeapon should equal(None)
    }
}