package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.repositories.WeaponRepository
import domain.models.WeaponTokenizer

class GameStartUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon name" in {
        val mockRepository = mock[WeaponRepository]
        val weaponNames = List("わかばシューター", "もみじシューター", "プロモデラーMG")
        (mockRepository.findAllWeaponNames _).expects().returning(weaponNames)

        val useCase = new GameStartUseCase(mockRepository)
        val result = useCase.run()
        val weaponName = WeaponTokenizer.decodeToken(result)
        Some(weaponName) should contain oneOf ("わかばシューター", "もみじシューター", "プロモデラーMG")
    }
}
