import domain._
import java.util.Date

object test {

  val dette1 = Dette(Montant(15, "EUR"), new Date(), 18)
                                                  //> dette1  : domain.Dette = Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 22:02:29
                                                  //|  CET 2012,18)

  val dette2 = Dette(Montant(30, "EUR"), new Date(), 9)
                                                  //> dette2  : domain.Dette = Dette(Montant(30.0,Devise(EUR)),Tue Dec 04 22:02:29
                                                  //|  CET 2012,9)
  val vide = Portefeuille("Port-1")               //> vide  : domain.Portefeuille = Portefeuille(Port-1,List())

  val port1 = vide.ajouteDette(dette1)            //> port1  : domain.Portefeuille = Portefeuille(Port-1,List(Dette(Montant(15.0,D
                                                  //| evise(EUR)),Tue Dec 04 22:02:29 CET 2012,18)))

  val port2 = port1 ajouteDette dette2            //> port2  : domain.Portefeuille = Portefeuille(Port-1,List(Dette(Montant(30.0,D
                                                  //| evise(EUR)),Tue Dec 04 22:02:29 CET 2012,9), Dette(Montant(15.0,Devise(EUR))
                                                  //| ,Tue Dec 04 22:02:29 CET 2012,18)))
}