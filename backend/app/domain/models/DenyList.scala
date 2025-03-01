package domain.models

/**
 * トークンの拒否リスト
 */
object DenyList {
    private var denyList: List[String] = List()
    private val MAX_SIZE = 1000
    
    /**
     * 拒否リストにトークンを追加する
     * @param token トークン
     */
    def add(token: String): Unit = {
        denyList = token :: denyList
        if (denyList.size > MAX_SIZE) {
            denyList = denyList.dropRight(1)
        }
    }
    
    /**
     * トークンが拒否リストに含まれているか
     * @param token トークン
     * @return 含まれているか
     */
    def contains(token: String): Boolean = {
        denyList.contains(token)
    }
}
