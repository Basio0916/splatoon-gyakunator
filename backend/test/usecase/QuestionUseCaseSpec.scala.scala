package usecase

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import domain.repositories.WeaponRepository
import domain.models._
import domain.services.JwtService
import play.api.libs.json.Json
import domain.services.BlackList
import domain.exceptions.InvalidTokenException

class QuestionUseCaseSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers with MockFactory {
    "run" should "return the correct answer" in {
        val mockRepository = mock[WeaponRepository]
        val mainWeapon = new MainWeapon(
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
        val subWeapon = new SubWeapon(
            name = "スプラッシュボム",
            inkConsumption = 70,
            damage = List(180.0, 30.0),
            isAttackType = Yes,
            canBePlaced = No,
            canInk = Yes,
            canMark = No
        )
        val specialWeapon = new SpecialWeapon(
            name = "グレートバリア",
            hasZRButtonAction = No,
            hasRButtonAction = No,
            canOneShot = No,
            dealsContinuousDamage = No,
            isAttackType = No,
            jumpsToUsePoint = Yes
        )
        val weapon = new Weapon(
            name = "わかばシューター",
            mainWeapon = mainWeapon,
            subWeapon = subWeapon,
            specialWeapon = specialWeapon,
            specialPoint = 180
        )

        (mockRepository.findWeaponByName _).expects("わかばシューター").returning(Some(weapon))
        val mockJwtService = mock[JwtService]
        (mockJwtService.generateJwt _).stubs("わかばシューター").returning("わかばシューター")
        (mockJwtService.decodeJwt _).stubs("わかばシューター").returning("わかばシューター")
        val jwt = mockJwtService.generateJwt("わかばシューター")
        val blackList = new BlackList()
        val useCase = new QuestionUseCase(mockRepository, mockJwtService, blackList)
        val answer = useCase.run(jwt, "MainWeaponMaxDamageQuestion", Some("25.0"), Some("以上？"))
        answer should equal(Yes)
    }

    it should "throw an exception if the token is contained in the blacklist" in {
        val mockRepository = mock[WeaponRepository]
        val mockJwtService = mock[JwtService]
        (mockJwtService.decodeJwt _).stubs("わかばシューター").returning("わかばシューター")
        val blackList = new BlackList()
        blackList.add("token")
        val useCase = new QuestionUseCase(mockRepository, mockJwtService, blackList)
        val thrown = intercept[InvalidTokenException] {
            useCase.run("token", "MainWeaponMaxDamageQuestion", Some("25.0"), Some("以上？"))
        }
        thrown.getMessage should equal("Invalid token")
    }
}