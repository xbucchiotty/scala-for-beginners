import domain.{Portefeuille, Montant, Dette}
import java.util.Date

val dette = Dette(Montant(5), 12, new Date())
println(dette)
val dette2 = Dette(Montant(5, "USD"), 12, new Date())
println(dette2)

val portefeuille = Portefeuille("Lancaster")
portefeuille ajouterUne dette

println(portefeuille)


