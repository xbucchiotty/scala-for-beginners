package domain

import java.util.Calendar.MONTH
import java.util.Date
import java.util.GregorianCalendar

case class DateEcheance(date: Date) {

  def ajoute1Mois(): DateEcheance = {
    var cal = new GregorianCalendar()
    cal.setTime(date);
    cal.add(MONTH, 1)
    DateEcheance(cal.getTime())
  }
}