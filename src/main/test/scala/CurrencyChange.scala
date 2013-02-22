import java.util.Currency

trait CurrencyChange {
  def doChange(m: Montant, target: Currency): Montant
}

object CurrencyChange {
  def Fixed(implicit table: Map[(Currency, Currency), Double]): CurrencyChange = new CurrencyChange {
    override def doChange(m: Montant, target: Currency): Montant = (
      table.get((m.devise, target))
        .orElse(table.get((target, m.devise)).map(1 / _))
        .map(changeRate => new Montant(m.valeur * changeRate, target))
        .getOrElse(new Montant(0, target))
      )
  }
}