package domain.models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DenyListSpec extends AnyFlatSpec with Matchers{
    "DenyList" should "add token correctly" in {
        DenyList.add("token1")
        DenyList.contains("token1") should equal(true)
    }

    it should "remove oldest token when the size exceeds the maximum size" in {
        val size = 1001;
        for (i <- 1 to size) {
            DenyList.add(s"token${i}")
        }
        
        DenyList.contains("token1") should equal(false)
        DenyList.contains(s"token${size}") should equal(true)
        DenyList.contains(s"token${size + 1}") should equal(false)
    }
  
}
