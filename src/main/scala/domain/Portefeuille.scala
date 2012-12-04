package domain

case class Portefeuille(nom: String, dettes: List[Dette]) {

  def ajouteDette(nouvelleDette: Dette): Portefeuille = {
    this.copy(dettes = nouvelleDette :: dettes)
  }

  def notionnelTotal(): Option[Montant] = {
    dettes
      .map(x => x.notionnel)
      .foldLeft(None: Option[Montant])((resultatTemp, montant) => Some(resultatTemp match {
        case None => montant
        case Some(autre) => Montant(autre.montant + montant.montant, montant.devise)
      }))
  }

  override def toString(): String = nom + "\n" + dettes.mkString("\n") + "\nnotionnel: " + notionnelTotal().map(_.toString)
}

object Portefeuille {
  def apply(nom: String): Portefeuille = Portefeuille(nom, Nil)
}