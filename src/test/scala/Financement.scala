import java.util.Date

case class Echeance(montant: Double, date: Date)

trait Financement {
  val flux: List[Echeance]
}

trait ContratCadre {
  def plafonds: List[Echeance]
}

trait RemboursementAnticipe {

  def opportunites: List[String]
}

trait Enveloppe {

  type TypeContratCadre <: ContratCadre

  val contratCadre: TypeContratCadre
}

class Revolving(val nom: String) extends ContratCadre {
  def plafonds: List[Echeance] = Nil
}

class TirageRevolving(val contratCadre: Revolving) extends Financement with Enveloppe with RemboursementAnticipe {

  type TypeContratCadre = Revolving

  def test = contratCadre.plafonds map println

  lazy val flux: List[Echeance] = getEcheancier

  private def getEcheancier: List[Echeance] = {
    waiting()
    List(Echeance(15, new Date()))
  }


  def waiting() {
    println("start")
    Thread.sleep(1000)
    println("end")
  }

  def opportunites: List[String] = Nil
}

class Emprunt {
  def flux: List[Echeance] = Nil
}

class AncienEmprunt {
  def echeancier: List[Echeance] = Nil
}


object TK {
  implicit def adaptationEmprunt: (AncienEmprunt => Emprunt) = {
    ancienEmprunt => new Emprunt {
      override val flux: List[Echeance] = ancienEmprunt.echeancier
    }

  }
}