package domain

trait Montant {

  def ajoute(autre: Option[Montant]): Montant
}

case class MontantEchec(val m1: Montant, val m2: Montant) extends Montant {

  override def ajoute(autre: Option[Montant]): Montant = this

  override def toString(): String = "Impossible de sommer des montantes de devises diffŽrentes (" + m1 + ", " + m2 + ")"
}

case class MontantValide(montant: Double, devise: Devise) extends Montant {

  override def ajoute(autre: Option[Montant]): Montant = autre match {
    case Some(MontantValide(m, d)) if (d == this.devise) => MontantValide(m + this.montant, d)
    case Some(MontantValide(m, d)) if (d != this.devise) => MontantEchec(this, autre.get)
    case Some(autreMontant) => autreMontant
    case None => this
  }
}

object Montant {
  def apply(montant: Double, devise: String): Montant = MontantValide(montant, Devise(devise))

  val aucun: Option[Montant] = None
}