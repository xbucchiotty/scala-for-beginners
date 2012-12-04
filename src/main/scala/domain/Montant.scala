package domain

case class Montant(montant: Double, devise: Devise) {

  def ajoute(autre: Montant): Option[Montant] = {
    if (autre.devise == this.devise)
      Some(Montant(autre.montant + this.montant, this.devise))
    else {
      None
    }
  }
}

object Montant {
  def apply(montant: Double, devise: String): Montant = Montant(montant, Devise(devise))
}