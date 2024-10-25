package domain.services

/**
 * トークンのブラックリスト
 */
class BlackList {
    private var blackList: List[String] = List()
    private val MAX_SIZE = 1000
    
    /**
     * ブラックリストにトークンを追加する
     * @param token トークン
     */
    def add(token: String): Unit = {
        blackList = token :: blackList
        if (blackList.size > MAX_SIZE) {
            blackList = blackList.dropRight(1)
        }
    }
    
    /**
     * トークンがブラックリストに含まれているか
     * @param token トークン
     * @return 含まれているか
     */
    def contains(token: String): Boolean = {
        blackList.contains(token)
    }
}
