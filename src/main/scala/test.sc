import domain._
import java.util.Date

object test {

  Dette(Montant(15, "EUR"), new Date(), 18)       //> res0: domain.Dette = Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 21:50:11 CET 
                                                  //| 2012,18)
}