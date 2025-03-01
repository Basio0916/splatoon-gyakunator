package domain.models

/**
  * ブキトークンの生成・解析
  */
object WeaponTokenizer {
  /**
    * ブキトークンを生成
    *
    * @param weaponName ブキ名
    * @param sessionId セッションID
    * @return トークン
    */
  def createToken(weaponName: String, sessionId: String): String = {
    s"${weaponName}_${sessionId}"
  }

  /**
    * トークンを解析
    *
    * @param token トークン
    * @return ブキ名
    */
  def decodeToken(token: String): String = {
    token.split("_").head
  }
}
