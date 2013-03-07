import java.util.Currency
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.HavePropertyMatcher
import org.scalatest.matchers.HavePropertyMatchResult
import org.scalatest.matchers.ShouldMatchers

case class Amount(value: Double, currency: Currency)

trait AmountMatch {
  def value(expectedValue: Double) = new HavePropertyMatcher[Amount, Double] {
    def apply(amount: Amount) = HavePropertyMatchResult(
      amount.value == expectedValue,
      "The value of the amount",
      expectedValue,
      amount.value
    )
  }
}

class AmountTest extends FunSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers with AmountMatch {

  describe("An amount") {
    it("should have a value") {
      val amount = Amount(15, Currency.getInstance("EUR"))

      amount should have(value(15d))
    }
  }
}

