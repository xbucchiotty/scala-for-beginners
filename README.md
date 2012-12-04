# Démarrer en Scala
## Objectif
* Apprendre les bases de Scala en codant une application simple de gestion d'emprunts. 
* Découvrir l'approche fonctionnelle
* Découvrir les bien-faits de l'immuabilité

## Déroulement
Du live-coding en pair sous la forme d'un kata. 

Les contraintes fonctionnelles sont amenées petit à petit pour apporter de nouvelles fonctionnalités de Scala.

## Prérequis
* Un IDE avec un plugin Scala (pour la complétion, ca va être utile !) et Scala Worksheet
* Un compilateur Scala 2.9.X

## Kata
### Créer une classe
On placera les classes métiers dans un package *domain* par convention

* Un **montant** est composé d'une *valeur* et d'une *devise*.
* Une **dette** est composée d'un *notionnel* (montant), d'une *durée* entière de mois et d'une *date de début*

Ouvrez ensuite un *Scala Worksheet* puis créer un une dette.


Points abordés:

* créer une classe
* ajouter des attributs
* utiliser une classe Java en Scala
* Utiliser une Scala Worsheet

### Case class et factory method
* Transformer les classes en case class.
* Créer une factory method sur Montant pour saisir une devise directement avec une string


On peut alors supprimer les val et les new dans le worksheet.

Points abordés:

* case class
* objet companion
* constructeur

### Création d'une méthode
* Un **portefeuille** est identifié par un *nom* et possède une liste de *dettes
* Je peux créer un portefeuille sans dette
* Je peux ajouter de la dette à un portefeuille

Points abordés:

* List, Nil et ::
* def, fonction et méthode
* func.apply(x) == func x

### Manipulation d'une liste
* Surcharger la méthode toString du portefeuille pour afficher les dettes par ligne

Points abordés:

* override
* map 
* mkString

### Manipulation d'une liste
* Je peux connaitre la **somme des notionnels** des dettes d'un portefeuille
* Je ne me soucis pas de la devise d'un montant
* Aucun montant est symbolisé par 0.00 et devise "" (peut être un singleton)

Le currying permet de dissocier les paramètres d'une fonction. Par exemple:

	def somme(f:(Int)=>Int,a:Int,b:Int):Int = f(a) + f(b)
	
	// est équivalent à 
	def somme(f:(Int)=>Int)(a:Int,b:Int):Int = f(a) + f(b)
	
	//Mais c'est composable
	def sommeCarres = somme(x => x * x) _  // (Int,Int) => Int
	sommeCarres(1,2) // = 5

A noter, il existe un raccourci pour les fonctions.

	x => x.maPropriete
peut s'écrire 

	_.maPropriete
	
Pour appliquer une fonction sur tous les éléments d'une collection

	maListe.map(x=> … )
	
Pour appliquer une fonction sur un élément de la liste et le résultat de cette fonction sur le reste

	maListe.map(<valeurInitiale>)((<typeRetour,<typeCollection>) => <typeRetour> )
	
Points abordés:

* map
* fold
* currying

### Option
* On ajoute le notionnelTotal dans le toString du portefeuille. Je veux voir "-" dans le cas d'un montant "aucun".
* On peut ajouter à un montant un autre montant.

 Montant.aucun n'était de toute façon pas conceptuellement satisfaisant.
 
Points abordés:

* Option, None, Some

### Pattern matching
* Refactoring des derniers if avec map et pattern matching
* Je peux voir None plutôt que "-" quand pas de montant


Points abordés:

* pattern matching avec option


### Either
* Je ne peux sommer deux montants de devise différentes
* Je veux savoir quelles étaients les deux montants de la somme s'il y a une erreur pendant l'opération
* Une somme de montant de devise différente produit un montant Echec
* Un montant Echec n'est pas la même chose qu'un montant Aucun

Either permet de modéliser un type de retour de méthode avec deux états différents. Le côté Left du Either est considéré comme celui portant l'erreur, le côté Right la valeur du cas nominal


Points abordés:

* Either, Left, Right

### Polymorphisme
* Remplacer le type Either lourd à gérer dans notre case un héritage

Le trait Montant devrait avoir la signature suivante : 

	trait Montant {
  		def ajoute(autre: Option[Montant]): Montant
	}


Points abordés:

* Pattern matching sur case class
* Trait
* Héritage

### Approche récursive
* Une dette une stratégie d'amortissement (infine ou linéaire)
* Un amortissement *infine* rembourse l'intégralité du notionnel lors de la dernière échéance
* Un amortissement *progressif* rembourse toujours la même part de capital sur toutes les échéances de la période
* Une dette possède un **échéancier d'amortissement** qui donne la liste des échéances d'amortissement selon la stratégie choisie
* Une **échéance d'amortissement** est composée d'une date d'échéance et d'un montant
* Sur une dette, je peux faire un println de chaque échéance

Pour cela, il faudra enrichir le trait Montant avec

	  def divisePar(coef: Double): Montant
	
	  def soustrait(autre: Montant): Montant
	  
Sans vouloir importer JodaTime, pour reculer une date d'un mois, il vous faudra:

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


Points abordés:

* Récursivité
* Inner-function

### Evaluation tardive et Stream
* Ajouter un thread.sleep(250) dans les fonctions récursives de calcul des échéances d'amortissement
* Il ne faut calculer l'échéancier qu'une seule fois
* Les échéances doivent s'afficher au fur et à mesure du calcul dans le worksheet

Le Stream est un type de collection dans Scala. Il contient une référence vers un élément (head), puis une expression évaluée tardivement pour la suite. Rien n'est jamais fait si on accède pas explicitement à la suite.
Pour ce faire, on peut utiliser

* toList
* flatten ou flatMap
* take

L'opérateur de construction de Stream est:

	head #:: tail

Points abordés:

* lazy val
* Stream

