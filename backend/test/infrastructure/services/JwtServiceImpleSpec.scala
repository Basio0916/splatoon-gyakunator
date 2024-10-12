package infrastructure.services

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class JwtServiceImpleSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "generateJwt" should "generate jwt" in {
        val jwtService = new JwtServiceImpl
        val jwt = jwtService.generateJwt("わかばシューター")
        jwt should not be empty
    }

    "decodeJwt" should "decode jwt" in {
        val jwtService = new JwtServiceImpl
        val jwt = jwtService.generateJwt("わかばシューター")
        val weaponName = jwtService.decodeJwt(jwt)
        weaponName should equal("わかばシューター")
    }

}