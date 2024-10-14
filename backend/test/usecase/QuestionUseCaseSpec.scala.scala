package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.repositories.WeaponRepository
import domain.models._
import domain.services.JwtService
import play.api.libs.json.Json

class QuestionUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
    "run" should "return the correct answer" in {
        var mockRepository = mock[WeaponRepository]
        var mainWeapon = new MainWeapon(
            name = "わかばシューター",
            weaponCategory = Shooter,
            range = List(1.6),
            damage = List(28.0),
            firingInterval = List(5.0),
            spread = List(12.0),
            weight = Light,
            canRapidFire = Yes,
            canCharge = Yes,
            isExplosive = No,
            canRollingOrBrushing = No,
            canChargeKeep = No,
            dodgeRollCount = 0,
            hasDirectHitSound = No
        )
        var subWeapon = new SubWeapon(
            name = "スプラッシュボム",
            inkConsumption = 70,
            damage = List(180.0, 30.0),
            isAttackType = Yes,
            canBePlaced = No,
            canInk = Yes,
            canMark = No
        )
        var specialWeapon = new SpecialWeapon(
            name = "グレートバリア",
            hasZRButtonAction = No,
            hasRButtonAction = No,
            canOneShot = No,
            dealsContinuousDamage = No,
            isAttackType = No,
            jumpsToUsePoint = Yes
        )
        var weapon = new Weapon(
            name = "わかばシューター",
            mainWeapon = mainWeapon,
            subWeapon = subWeapon,
            specialWeapon = specialWeapon,
            specialPoint = 180
        )

        (mockRepository.findWeaponByName _).expects("わかばシューター").returning(Some(weapon))
        var mockJwtService = mock[JwtService]
        (mockJwtService.generateJwt _).stubs("わかばシューター").returning("わかばシューター")
        (mockJwtService.decodeJwt _).stubs("わかばシューター").returning("わかばシューター")
        var jwt = mockJwtService.generateJwt("わかばシューター")
        
        var useCase = new QuestionUseCase(mockRepository, mockJwtService)
        var questionInput = new QuestionInput(jwt, "MainWeaponMaxDamageQuestion", Some("25.0"), Some("以上？"))
        val answer = useCase.run(questionInput)
        answer should equal(Yes)
    }
}