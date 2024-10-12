package domain.services

trait JwtService{
  def generateJwt(weaponName: String): String
  def decodeJwt(token: String): String
}