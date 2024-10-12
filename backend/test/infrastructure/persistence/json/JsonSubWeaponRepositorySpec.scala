package infrastructure.persistence.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import domain.models._
import domain.factories.SourceFactory

class JsonSubWeaponRepositorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "findSubWeaponByName" should "find sub weapon by name" in {

        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.subWeapons)
        }
        val repository = new JsonSubWeaponRepository(sourceFactory)
        val subWeapon = repository.findSubWeaponByName("スプラッシュボム")
        subWeapon.get.name should equal("スプラッシュボム")
        subWeapon.get.inkConsumption should equal(70)
        subWeapon.get.damage should equal(List(180.0, 30.0))
        subWeapon.get.isAttackType should equal(Yes)
        subWeapon.get.canBePlaced should equal(No)
        subWeapon.get.canInk should equal(Yes)
        subWeapon.get.canMark should equal(No)
    }

    it should "return None if sub weapon is not found" in {
        val sourceFactory = new SourceFactory{
            def createSource: Source = Source.fromString(JsonData.subWeapons)
        }
        val repository = new JsonSubWeaponRepository(sourceFactory)
        val subWeapon = repository.findSubWeaponByName("チェイスボム")
        subWeapon should equal(None)
    }
}