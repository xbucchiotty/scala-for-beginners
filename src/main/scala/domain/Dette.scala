package domain

import java.util.Date

case class Dette(
  notionnel: Montant,
  dateDebut: Date,
  dureeMois: Int,
  amortissement: StrategieAmortissement) {

  def afficherEcheancierAmortissement() = amortissement.echeancier(notionnel, dateDebut, dureeMois) map println

}