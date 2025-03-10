package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.repositories.WeaponRepository
import domain.services.JwtService

class GameStartUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
  
    "run" should "return weapon name" in {
        val mockRepository = mock[WeaponRepository]
        val weaponNames = List("わかばシューター", "もみじシューター", "プロモデラーMG")
        (mockRepository.findAllWeaponNames _).expects().returning(weaponNames)

        val mockJwtService = mock[JwtService]
        (mockJwtService.generateJwt _).stubs("わかばシューター").returning("わかばシューター")
        (mockJwtService.generateJwt _).stubs("もみじシューター").returning("もみじシューター")
        (mockJwtService.generateJwt _).stubs("プロモデラーMG").returning("プロモデラーMG")
        (mockJwtService.decodeJwt _).stubs("わかばシューター").returning("わかばシューター")
        (mockJwtService.decodeJwt _).stubs("もみじシューター").returning("もみじシューター")
        (mockJwtService.decodeJwt _).stubs("プロモデラーMG").returning("プロモデラーMG")

        val useCase = new GameStartUseCase(mockRepository, mockJwtService)
        val result = useCase.run()
        Some(result) should contain oneOf ("わかばシューター", "もみじシューター", "プロモデラーMG")
    }
}
