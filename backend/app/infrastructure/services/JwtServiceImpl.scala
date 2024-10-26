package infrastructure.services

import domain.services.JwtService
import pdi.jwt.{Jwt, JwtAlgorithm, JwtClaim}
import play.api.libs.json.Json
import scala.io.Source
import java.time.LocalDateTime
import javax.inject.Singleton
/**
 * JWTサービスの実装
 */
@Singleton
class JwtServiceImpl extends JwtService {
  val secretKey: String = getSecretKey

  private def getSecretKey: String = {
    sys.env.getOrElse("JWT_SECRET", "secret")
  }

  def generateJwt(weaponName: String): String = {
    val currentDateTime = LocalDateTime.now()
    val json = Json.obj("weaponName" -> s"${weaponName}_${currentDateTime}")
    val claim = JwtClaim(json.toString())
    Jwt.encode(claim, secretKey, JwtAlgorithm.HS256)
  }

  def decodeJwt(token: String): String = {
    Jwt.decode(token, secretKey, Seq(JwtAlgorithm.HS256)).toOption.flatMap { claim =>
      val json = Json.parse(claim.content)
      (json \ "weaponName").asOpt[String].map((weaponNameWithDateTime: String) => {
        val dateTime = weaponNameWithDateTime.split("_").last
        weaponNameWithDateTime.replace(s"_${dateTime}", "")
      })
    }.getOrElse(throw new IllegalArgumentException("Invalid token"))
  }
}