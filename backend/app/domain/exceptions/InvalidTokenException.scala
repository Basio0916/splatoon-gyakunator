package domain.exceptions

/**
 * トークンが無効な場合の例外
 */
final case class InvalidTokenException() extends Exception("Invalid token")
