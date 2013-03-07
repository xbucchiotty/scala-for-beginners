import java.util.Currency

case class Montant(valeur: Double, devise: Currency) {
  def +(rightOperande: Montant)(implicit changer: CurrencyChange) = rightOperande match {
    case Montant(valueRightOperande, this.devise) => copy(valeur = valueRightOperande + this.valeur)
    case _ => {
      val changed: Montant = rightOperande to this.devise
      copy(valeur = changed.valeur + this.valeur)
    }
  }

  def *(coef: Double) = copy(valeur = coef * valeur)

  def to(target: Currency)(implicit changer: CurrencyChange) = changer.doChange(this, target)

}
