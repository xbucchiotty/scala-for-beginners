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

