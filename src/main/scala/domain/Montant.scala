package domain

import java.util.Currency

case class Montant(valeur: Double, devise: Currency = Currency.getInstance("EUR"))

object Montant {

  def apply (valeur: Double, devise: String) = new Montant(valeur, Currency.getInstance(devise))

}