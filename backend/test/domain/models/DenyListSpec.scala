package domain.models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DenyListSpec extends AnyFlatSpec with Matchers{
    "DenyList" should "add token correctly" in {
        val denyList = new DenyList()
        denyList.add("token1")
        denyList.contains("token1") should equal(true)
    }

    it should "remove oldest token when the size exceeds the maximum size" in {
        val denyList = new DenyList()
        val size = 1001;
        for (i <- 1 to size) {
            denyList.add(s"token${i}")
        }
        
        denyList.contains("token1") should equal(false)
        denyList.contains(s"token${size}") should equal(true)
        denyList.contains(s"token${size + 1}") should equal(false)
    }
  
}
