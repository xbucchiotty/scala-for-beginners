import domain._
import java.util.Date

object test {

  val dette1 = Dette(Montant(15, "EUR"), new Date(), 18)
                                                  //> dette1  : domain.Dette = Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 22:43:01
                                                  //|  CET 2012,18)

  val dette2 = Dette(Montant(30, "EUR"), new Date(), 9)
                                                  //> dette2  : domain.Dette = Dette(Montant(30.0,Devise(EUR)),Tue Dec 04 22:43:01
                                                  //|  CET 2012,9)
  val vide = Portefeuille("Port-1")               //> vide  : domain.Portefeuille = Port-1
                                                  //| 
  vide.notionnelTotal                             //> res0: domain.Montant = Montant(0.0,Devise())

  val port1 = vide.ajouteDette(dette1)            //> port1  : domain.Portefeuille = Port-1
                                                  //| Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 22:43:01 CET 2012,18)
  port1.notionnelTotal                            //> res1: domain.Montant = Montant(15.0,Devise(EUR))

  val port2 = port1 ajouteDette dette2            //> port2  : domain.Portefeuille = Port-1
                                                  //| Dette(Montant(30.0,Devise(EUR)),Tue Dec 04 22:43:01 CET 2012,9)
                                                  //| Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 22:43:01 CET 2012,18)
  port2.notionnelTotal                            //> res2: domain.Montant = Montant(45.0,Devise(EUR))
}