package application.service

import scala.io.Source
import pdi.jwt.{Jwt, JwtAlgorithm, JwtClaim}
import play.api.libs.json.Json

object JwtService{
  
  val secretKey: String = getSecretKey

  private def getSecretKey: String = {
    val source = Source.fromResource("secret.txt")
    try source.mkString finally source.close()
  }

  def generateJwt(weaponName: String): String = {
    val json = Json.obj("weaponName" -> weaponName)
    val claim = JwtClaim(json.toString())
    Jwt.encode(claim, secretKey, JwtAlgorithm.HS256)
  }

  def decodeJwt(token: String): String = {
      Jwt.decode(token, secretKey, Seq(JwtAlgorithm.HS256)).toOption.flatMap { claim =>
        val json = Json.parse(claim.content)
        (json \ "weaponName").asOpt[String]
      }.getOrElse(throw new IllegalArgumentException("Invalid token"))
  }
}