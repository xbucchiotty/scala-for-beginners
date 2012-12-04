package domain

case class Portefeuille(nom: String, dettes: List[Dette]) {

  def ajouteDette(nouvelleDette: Dette): Portefeuille = {
    this.copy(dettes = nouvelleDette :: dettes)
  }

  def notionnelTotal(): Option[Montant] = {
    dettes
      .map(x => x.notionnel)
      .foldLeft(Montant.aucun)((resultatTemp, montant) => Some(montant.ajoute(resultatTemp)))
  }

  override def toString(): String = nom + "\n" + dettes.mkString("\n") + "\nnotionnel: " + notionnelTotal().map(_.toString)
}

object Portefeuille {
  def apply(nom: String): Portefeuille = Portefeuille(nom, Nil)
}