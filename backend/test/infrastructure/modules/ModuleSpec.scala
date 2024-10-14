package infrastructure.modules

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import com.google.inject.Guice
import domain.repositories.WeaponRepository

class ModuleSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers{

    "WeaponRepository" should "return the correct weapon" in {
        val injector = Guice.createInjector(new Module)
        val weaponRepository = injector.getInstance(classOf[WeaponRepository])
        val weapon = weaponRepository.findWeaponByName("わかばシューター")
        weapon.get.name should equal("わかばシューター")
        weapon.get.mainWeapon.name should equal("わかばシューター")
        weapon.get.subWeapon.name should equal("スプラッシュボム")
        weapon.get.specialWeapon.name should equal("グレートバリア")
    }
}