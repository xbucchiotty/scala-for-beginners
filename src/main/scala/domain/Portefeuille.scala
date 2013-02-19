package domain

import collection.mutable.ListBuffer

class Portefeuille(val nom: String, var dettes: ListBuffer[Dette] = Nil) {

  def ajouterUne(dette: Dette) {
    dettes += dette
  }


}
