package domain.services

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BlackListSpec extends AnyFlatSpec with Matchers{
    "BlackList" should "add token correctly" in {
        val blackList = new BlackList()
        blackList.add("token1")
        blackList.contains("token1") should equal(true)
    }

    it should "remove oldest token when the size exceeds the maximum size" in {
        val blackList = new BlackList()
        val size = 1001;
        for (i <- 1 to size) {
            blackList.add(s"token${i}")
        }
        
        blackList.contains("token1") should equal(false)
        blackList.contains(s"token${size}") should equal(true)
        blackList.contains(s"token${size + 1}") should equal(false)
    }
  
}
