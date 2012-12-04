import domain._
import java.util.Date

object test {

  new Dette(new Montant(15, new Devise("EUR")), new Date(), 18)
                                                  //> res0: domain.Dette = domain.Dette@1b543c88
}