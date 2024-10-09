package infrastructure.persistence.json

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import domain.model._

class JsonWeaponRepositorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{
    "findWeaponByName" should "find weapon by name" in {

        val source = Source.fromString(JsonData.jsonString)
        val repository = new JsonWeaponRepository(source)
        val weapon = repository.findWeaponByName("わかばシューター")
        weapon.get.name should equal("わかばシューター")
    }

    it should "return None if weapon is not found" in {
        val source = Source.fromString(JsonData.jsonString)
        val repository = new JsonMainWeaponRepository(source)
        val mainWeapon = repository.findMainWeaponByName("リッター4K")
        mainWeapon should equal(None)
    }
}