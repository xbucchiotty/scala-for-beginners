import java.util.Currency

case class Montant(montant: Double, devise: Currency) {
  def +(m: Montant) = this.copy(montant = m.montant + montant)

  def *(coef: Double) = this.copy(montant = montant * coef)

}

object Convert {
  implicit def numericAsCoef(coef: Double) = new {
    def *(m: Montant): Montant = m * coef
  }

  implicit def stringToCurrency(currencyCode: String) = Currency.getInstance(currencyCode)
}
import Convert.{numericAsCoef, stringToCurrency}
val _10_EUR = Montant(10, "EUR")
val _15_EUR = Montant(15, "EUR")
_10_EUR + _15_EUR
_10_EUR * 10
10 * _10_EUR

