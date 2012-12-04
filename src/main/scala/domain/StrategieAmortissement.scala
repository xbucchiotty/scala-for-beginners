package domain

import java.util.Date
import java.lang.Thread

trait StrategieAmortissement {

  def echeancier(notionnel: Montant, dateDebut: Date, dureeMois: Int): Stream[EcheanceAmortissement]
}

object AmortissementLineaire extends StrategieAmortissement {

  override def echeancier(notionnel: Montant, dateDebut: Date, dureeMois: Int): Stream[EcheanceAmortissement] = {
    val amortissement = notionnel divisePar dureeMois

    def loop(notionnelRestant: Montant, dateEcheance: DateEcheance, dureeRestante: Int): Stream[EcheanceAmortissement] = {
      Thread.sleep(250)

      if (dureeRestante < 1)
        Stream.Empty
      else
        EcheanceAmortissement(dateEcheance, amortissement) #:: loop(notionnelRestant soustrait amortissement, dateEcheance.ajoute1Mois, dureeRestante - 1)
    }

    loop(notionnel, DateEcheance(dateDebut), dureeMois)
  }
}

object AmortissementInfine extends StrategieAmortissement {

  override def echeancier(notionnel: Montant, dateDebut: Date, dureeMois: Int): Stream[EcheanceAmortissement] = {
    val zero = notionnel match {
      case MontantValide(m, d) => MontantValide(0, d)
      case _ => notionnel
    }

    def loop(dateEcheance: DateEcheance, dureeRestante: Int): Stream[EcheanceAmortissement] = {
      Thread.sleep(250)

      if (dureeRestante < 1) {
        Stream.Empty
      } else {
        if (dureeRestante == 1) {
          Stream(EcheanceAmortissement(dateEcheance, notionnel))
        } else {
          EcheanceAmortissement(dateEcheance, zero) #:: loop(dateEcheance.ajoute1Mois, dureeRestante - 1)
        }
      }

    }

    loop(DateEcheance(dateDebut), dureeMois)
  }
}

object StrategieAmortissement {

  def lineaire: StrategieAmortissement = AmortissementLineaire
  def infine: StrategieAmortissement = AmortissementInfine
} 