package application.service

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class JwtServiceSpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {

    "generateJwt" should "generate jwt" in {
        val jwt = JwtService.generateJwt("わかばシューター")
        jwt should not be empty
    }

    "decodeJwt" should "decode jwt" in {
        val jwt = JwtService.generateJwt("わかばシューター")
        val weaponName = JwtService.decodeJwt(jwt)
        weaponName should equal("わかばシューター")
    }

}