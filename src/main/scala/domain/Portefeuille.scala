package domain

case class Portefeuille(nom: String, dettes: List[Dette]) {

  def ajouteDette(nouvelleDette: Dette): Portefeuille = {
    this.copy(dettes = nouvelleDette :: dettes)
  }

  def notionnelTotal(): Montant = {
    dettes
      .map(x => x.notionnel)
      .foldLeft(Montant.aucun)((a, b) => Montant(a.montant + b.montant, b.devise))
  }

  override def toString(): String = nom + "\n" + dettes.mkString("\n")
}

object Portefeuille {
  def apply(nom: String): Portefeuille = Portefeuille(nom, Nil)
}