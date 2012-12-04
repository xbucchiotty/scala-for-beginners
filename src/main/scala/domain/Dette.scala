package domain

import java.util.Date

case class Dette(
  notionnel: Montant,
  dateDebut: Date,
  dureeMois: Int,
  amortissement: StrategieAmortissement) {

  lazy val echeancier = amortissement.echeancier(notionnel, dateDebut, dureeMois)
  
  def afficherEcheancierAmortissement() = echeancier.print("\n")

}