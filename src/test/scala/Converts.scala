import java.util.Currency

object Converts {
  implicit def stringToCurrency(currencyCode: String) = Currency.getInstance(currencyCode)

  implicit def numericAsCoef(coef: Double) = new {
    def *(m: Montant): Montant = m * coef
  }
}
