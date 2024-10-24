package domain.services

/**
 * JWTサービス
 */
trait JwtService{
  /**
   * JWTを生成する
   * @param weaponName ブキ名
   * @return JWT
   */
  def generateJwt(weaponName: String): String

  /**
   * JWTをデコードする
   * @param token JWT
   * @return ブキ名
   */
  def decodeJwt(token: String): String
}