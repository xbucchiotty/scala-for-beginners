import domain._
import domain.StrategieAmortissement.lineaire
import domain.StrategieAmortissement.infine
import java.util.Date

object test {

  val dette1 = Dette(Montant(15, "EUR"), new Date(), 18, infine)
                                                  //> dette1  : domain.Dette = Dette(MontantValide(15.0,Devise(EUR)),Wed Dec 05 00
                                                  //| :33:56 CET 2012,18,domain.AmortissementInfine$@3a21b220)
  dette1.afficherEcheancierAmortissement          //> EcheanceAmortissement(DateEcheance(Wed Dec 05 00:33:56 CET 2012),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Jan 05 00:33:56 CET 2013),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Feb 05 00:33:56 CET 2013),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Mar 05 00:33:56 CET 2013),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Fri Apr 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sun May 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Wed Jun 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Fri Jul 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Mon Aug 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Thu Sep 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Oct 05 00:33:56 CEST 2013),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Nov 05 00:33:56 CET 2013),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Thu Dec 05 00:33:56 CET 2013),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sun Jan 05 00:33:56 CET 2014),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Wed Feb 05 00:33:56 CET 2014),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Wed Mar 05 00:33:56 CET 2014),MontantVali
                                                  //| de(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Apr 05 00:33:56 CEST 2014),MontantVal
                                                  //| ide(0.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Mon May 05 00:33:56 CEST 2014),MontantVal
                                                  //| ide(15.0,Devise(EUR)))
                                                  //| empty

  val dette2 = Dette(Montant(30, "EUR"), new Date(), 6, lineaire)
                                                  //> dette2  : domain.Dette = Dette(MontantValide(30.0,Devise(EUR)),Wed Dec 05 00
                                                  //| :34:00 CET 2012,6,domain.AmortissementLineaire$@76f8968f)
  dette2.afficherEcheancierAmortissement          //> EcheanceAmortissement(DateEcheance(Wed Dec 05 00:34:00 CET 2012),MontantVali
                                                  //| de(5.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Jan 05 00:34:00 CET 2013),MontantVali
                                                  //| de(5.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Feb 05 00:34:00 CET 2013),MontantVali
                                                  //| de(5.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Mar 05 00:34:00 CET 2013),MontantVali
                                                  //| de(5.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Fri Apr 05 00:34:00 CEST 2013),MontantVal
                                                  //| ide(5.0,Devise(EUR)))
                                                  //| EcheanceAmortissement(DateEcheance(Sun May 05 00:34:00 CEST 2013),MontantVal
                                                  //| ide(5.0,Devise(EUR)))
                                                  //| empty

  val dette3 = Dette(Montant(20, "USD"), new Date(), 20, lineaire)
                                                  //> dette3  : domain.Dette = Dette(MontantValide(20.0,Devise(USD)),Wed Dec 05 00
                                                  //| :34:02 CET 2012,20,domain.AmortissementLineaire$@76f8968f)
  dette3.afficherEcheancierAmortissement          //> EcheanceAmortissement(DateEcheance(Wed Dec 05 00:34:02 CET 2012),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Jan 05 00:34:02 CET 2013),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Feb 05 00:34:02 CET 2013),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Mar 05 00:34:02 CET 2013),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Fri Apr 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Sun May 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Wed Jun 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Fri Jul 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Mon Aug 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Thu Sep 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Oct 05 00:34:02 CEST 2013),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Tue Nov 05 00:34:02 CET 2013),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Thu Dec 05 00:34:02 CET 2013),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Sun Jan 05 00:34:02 CET 2014),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Wed Feb 05 00:34:02 CET 2014),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Wed Mar 05 00:34:02 CET 2014),MontantVali
                                                  //| de(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Apr 05 00:34:02 CEST 2014),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Mon May 05 00:34:02 CEST 2014),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Thu Jun 05 00:34:02 CEST 2014),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| EcheanceAmortissement(DateEcheance(Sat Jul 05 00:34:02 CEST 2014),MontantVal
                                                  //| ide(1.0,Devise(USD)))
                                                  //| empty

  val vide = Portefeuille("Port-1")               //> vide  : domain.Portefeuille = Port-1
                                                  //| 
                                                  //| notionnel: None

  val port1 = vide.ajouteDette(dette1)            //> port1  : domain.Portefeuille = Port-1
                                                  //| Dette(MontantValide(15.0,Devise(EUR)),Wed Dec 05 00:33:56 CET 2012,18,domain
                                                  //| .AmortissementInfine$@3a21b220)
                                                  //| notionnel: Some(MontantValide(15.0,Devise(EUR)))

  val port2 = port1 ajouteDette dette2            //> port2  : domain.Portefeuille = Port-1
                                                  //| Dette(MontantValide(30.0,Devise(EUR)),Wed Dec 05 00:34:00 CET 2012,6,domain.
                                                  //| AmortissementLineaire$@76f8968f)
                                                  //| Dette(MontantValide(15.0,Devise(EUR)),Wed Dec 05 00:33:56 CET 2012,18,domain
                                                  //| .AmortissementInfine$@3a21b220)
                                                  //| notionnel: Some(MontantValide(45.0,Devise(EUR)))
  val port3 = port2 ajouteDette dette3            //> port3  : domain.Portefeuille = Port-1
                                                  //| Dette(MontantValide(20.0,Devise(USD)),Wed Dec 05 00:34:02 CET 2012,20,domain
                                                  //| .AmortissementLineaire$@76f8968f)
                                                  //| Dette(MontantValide(30.0,Devise(EUR)),Wed Dec 05 00:34:00 CET 2012,6,domain.
                                                  //| AmortissementLineaire$@76f8968f)
                                                  //| Dette(MontantValide(15.0,Devise(EUR)),Wed Dec 05 00:33:56 CET 2012,18,domain
                                                  //| .AmortissementInfine$@3a21b220)
                                                  //| notionnel: Some(Impossible de sommer des montantes de devises différentes (M
                                                  //| ontantValide(30.0,Devise(EUR)), MontantValide(20.0,Devise(USD))))
}