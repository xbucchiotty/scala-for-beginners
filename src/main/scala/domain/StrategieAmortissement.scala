package domain

import java.util.Date

trait StrategieAmortissement {

  def echeancier(notionnel: Montant, dateDebut: Date, dureeMois: Int): List[EcheanceAmortissement]
}

object AmortissementLineaire extends StrategieAmortissement {

  override def echeancier(notionnel: Montant, dateDebut: Date, dureeMois: Int): List[EcheanceAmortissement] = {
    val amortissement = notionnel divisePar dureeMois

    def loop(notionnelRestant: Montant, dateEcheance: DateEcheance, dureeRestante: Int): List[EcheanceAmortissement] = {
      if (dureeRestante < 1)
        Nil
      else
        EcheanceAmortissement(dateEcheance, amortissement) :: loop(notionnelRestant soustrait amortissement, dateEcheance.ajoute1Mois, dureeRestante - 1)
    }

    loop(notionnel, DateEcheance(dateDebut), dureeMois)
  }
}

object AmortissementInfine extends StrategieAmortissement {

  override def echeancier(notionnel: Montant, dateDebut: Date, dureeMois: Int): List[EcheanceAmortissement] = {
    val zero = notionnel match {
      case MontantValide(m, d) => MontantValide(0, d)
      case _ => notionnel
    }

    def loop(dateEcheance: DateEcheance, dureeRestante: Int): List[EcheanceAmortissement] = {
      if (dureeRestante < 1) {
        Nil
      } else {
        if (dureeRestante == 1) {
          EcheanceAmortissement(dateEcheance, notionnel) :: Nil
        } else {
          EcheanceAmortissement(dateEcheance, zero) :: loop(dateEcheance.ajoute1Mois, dureeRestante - 1)
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