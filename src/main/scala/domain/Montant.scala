package domain

case class Montant(montant: Double, devise: Devise) {

  def ajoute(autre: Option[Either[String, Montant]]): Option[Either[String, Montant]] = {
    autre match {
      case Some(Right(autreMontant)) if (autreMontant.devise == devise) => Some(Right(Montant(autreMontant.montant + montant, devise)))
      case Some(Right(autreMontant)) if (autreMontant.devise != devise) => Some(Left("Impossible de sommer des montants de devises diffŽrentes (" + this + " et " + autreMontant + ")"))
      case Some(Left(_)) => autre
      case None => Some(Right(this))
    }
  }
}

object Montant {
  def apply(montant: Double, devise: String): Montant = Montant(montant, Devise(devise))
}