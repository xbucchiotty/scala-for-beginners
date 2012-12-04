package domain

case class Portefeuille(nom: String, dettes: List[Dette]) {

  def ajouteDette(nouvelleDette: Dette): Portefeuille = {
    this.copy(dettes = nouvelleDette :: dettes)
  }

  def notionnelTotal(): Option[Montant] = {
    dettes
      .map(x => x.notionnel)
      .foldLeft(None: Option[Montant])((resultatTemp, montant) => {
        Some(
          if (!resultatTemp.isDefined) montant
          else Montant(resultatTemp.get.montant + montant.montant, montant.devise))
      })
  }

  override def toString(): String = nom + "\n" + dettes.mkString("\n") + "\nnotionnel: " + (if (this.notionnelTotal().isDefined) this.notionnelTotal().toString() else "-")
}

object Portefeuille {
  def apply(nom: String): Portefeuille = Portefeuille(nom, Nil)
}