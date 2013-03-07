import java.util.Currency

import Converts.stringToCurrency
import CurrencyChange.Fixed

implicit val changer = Fixed(Map((Currency.getInstance("USD"), Currency.getInstance("EUR")) -> 1.45))

val _0_EUR = Montant(0, "EUR")
val _10_EUR = new Montant(10, "EUR")
val _10_USD = new Montant(10, "USD")
_10_EUR + _10_USD
_10_USD + _10_EUR
_10_USD to "EUR"

val list = List(_10_EUR, _10_USD)
list.foldLeft(Montant(0, "EUR"))(_ + _)

(_0_EUR /: list)(_ + _)