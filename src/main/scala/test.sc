import domain._
import java.util.Date

object test {

  val dette1 = Dette(Montant(15, "EUR"), new Date(), 18)
                                                  //> dette1  : domain.Dette = Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 23:22:02
                                                  //|  CET 2012,18)

  val dette2 = Dette(Montant(30, "EUR"), new Date(), 9)
                                                  //> dette2  : domain.Dette = Dette(Montant(30.0,Devise(EUR)),Tue Dec 04 23:22:03
                                                  //|  CET 2012,9)

  val dette3 = Dette(Montant(20, "USD"), new Date(), 1)
                                                  //> dette3  : domain.Dette = Dette(Montant(20.0,Devise(USD)),Tue Dec 04 23:22:03
                                                  //|  CET 2012,1)
  val vide = Portefeuille("Port-1")               //> vide  : domain.Portefeuille = Port-1
                                                  //| 
                                                  //| notionnel: None

  val port1 = vide.ajouteDette(dette1)            //> port1  : domain.Portefeuille = Port-1
                                                  //| Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 23:22:02 CET 2012,18)
                                                  //| notionnel: Some(Right(Montant(15.0,Devise(EUR))))

  val port2 = port1 ajouteDette dette2            //> port2  : domain.Portefeuille = Port-1
                                                  //| Dette(Montant(30.0,Devise(EUR)),Tue Dec 04 23:22:03 CET 2012,9)
                                                  //| Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 23:22:02 CET 2012,18)
                                                  //| notionnel: Some(Right(Montant(45.0,Devise(EUR))))
  val port3 = port2 ajouteDette dette3            //> port3  : domain.Portefeuille = Port-1
                                                  //| Dette(Montant(20.0,Devise(USD)),Tue Dec 04 23:22:03 CET 2012,1)
                                                  //| Dette(Montant(30.0,Devise(EUR)),Tue Dec 04 23:22:03 CET 2012,9)
                                                  //| Dette(Montant(15.0,Devise(EUR)),Tue Dec 04 23:22:02 CET 2012,18)
                                                  //| notionnel: Some(Left(Impossible de sommer des montants de devises différente
                                                  //| s (Montant(30.0,Devise(EUR)) et Montant(20.0,Devise(USD)))))
}