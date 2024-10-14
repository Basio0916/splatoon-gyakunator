package infrastructure.services

import domain.services.JwtService
import pdi.jwt.{Jwt, JwtAlgorithm, JwtClaim}
import play.api.libs.json.Json
import scala.io.Source
import java.security.SecureRandom

class JwtServiceImpl extends JwtService {
  val secretKey: String = getSecretKey

  private def getSecretKey: String = {
    val source = Source.fromResource("secret.txt")
    try source.mkString finally source.close()
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