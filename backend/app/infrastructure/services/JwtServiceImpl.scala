package infrastructure.services

import domain.services.JwtService
import pdi.jwt.{Jwt, JwtAlgorithm, JwtClaim}
import play.api.libs.json.Json
import scala.io.Source
import java.security.SecureRandom

class JwtServiceImpl extends JwtService {
  val secretKey: String = getSecretKey

  private def getSecretKey: String = {
    sys.env.getOrElse("JWT_SECRET", throw new RuntimeException("JWT_SECRET environment variable not found"))
  }

  def generateJwt(weaponName: String): String = {
    val nonce = new SecureRandom().nextInt(10000)
    val json = Json.obj("weaponName" -> s"$weaponName-$nonce")
    val claim = JwtClaim(json.toString())
    Jwt.encode(claim, secretKey, JwtAlgorithm.HS256)
  }

  def decodeJwt(token: String): String = {
    Jwt.decode(token, secretKey, Seq(JwtAlgorithm.HS256)).toOption.flatMap { claim =>
      val json = Json.parse(claim.content)
      (json \ "weaponName").asOpt[String].map((weaponNameWithNonce: String) => {
        val nonce = weaponNameWithNonce.split("-").last
        weaponNameWithNonce.replace(s"-$nonce", "")
      })
    }.getOrElse(throw new IllegalArgumentException("Invalid token"))
  }
}