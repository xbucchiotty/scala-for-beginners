package domain

case class Montant(montant: Double, devise: Devise) {

}

object Montant {
  def apply(montant: Double, devise: String): Montant = Montant(montant, Devise(devise))

  val aucun: Montant = Montant(0, "")
}