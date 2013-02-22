import java.util.Currency

case class Montant(montant: Double, devise: Currency)
object Convert {
  implicit def stringToCurrency(currencyCode: String) = Currency.getInstance(currencyCode)
}

import Convert.stringToCurrency

Montant(15, "JPY")