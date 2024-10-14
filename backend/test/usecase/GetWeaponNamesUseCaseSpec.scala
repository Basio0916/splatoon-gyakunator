package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.repositories.WeaponRepository

class GetWeaponNamesUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon names" in {
        var mockRepository = mock[WeaponRepository]
        var weaponNames = List("わかばシューター", "もみじシューター", "プロモデラーMG")
        (mockRepository.findAllWeaponNames _).expects().returning(weaponNames)
        var useCase = new GetWeaponNamesUseCase(mockRepository)
        useCase.run() should equal(weaponNames)
    }
}
