package domain.models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import java.util.UUID

class WeaponTokenizerSpec extends AnyFlatSpec with Matchers{
    "WeaponTokenizer#create" should "create weapon token with session id" in {
        val sessionId = UUID.randomUUID().toString()
        val weaponName = "わかばシューター"
        val expected = s"${weaponName}_${sessionId}"

        val token = WeaponTokenizer.createToken(weaponName, sessionId)
        token should equal(expected)
    }

    "WeaponTokenizer#decode" should "decode weapon token" in {
        val sessionId = UUID.randomUUID().toString()
        val weaponName = "わかばシューター"
        val token = s"${weaponName}_${sessionId}"

        val decoded = WeaponTokenizer.decodeToken(token)
        decoded should equal(weaponName)
    }
  
}
