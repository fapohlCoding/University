package DynamischesBinden;
/* A Class, showing the different abilities of birds in the aviary
 *
 * @author Fabian Pohl
 */
public class Aviary {

   public static void main(String[] args) {
      Dodo dodo = new Dodo();

      System.out.println("1: ((Bird)dodo).ability           : " + ((Bird) dodo).ability);
      /*
       * 1. Es wird die Instanz vom Typ Dodo zu einem Bird gecastet. Von der gecasteten Instanz
       *   	wird der Wert des public Attributes ability abgerufen und ausgegeben. 
       *    Rückgabe --> Wert des Attributes der Klasse Bird --> statisch
      */
      System.out.println("2: dodo.ability                   : " + dodo.ability);
      /*
       * 2. Es wird direkt die Instanz vom Typ Dodo aufgegabelt. An der Instanz wird der Wert
       * 	des public Attributes ability abgerufen und ausgegeben. 
       * 	Rückgabe --> Wert des Attributes der Klasse Dodo --> statisch
       */
      System.out.println("3: dodo.getAbility()              : " + dodo.getAbility());
      /*
       * 3.	Es wird die getAbility Methode der Dodo Instanz abgerufen (dynamisch), die den Wert der getAbility
       * 	Methode der Superklasse zurückliefert. Die Superklasse des Dodos ist die Bird Klasse. 
       * 	Rückgabe --> Wert des Attributes von der Klasse Bird --> statisch
       */
      Parrot parrot = new Parrot();
      System.out.println("4: parrot.allAbilities            : " + parrot.allAbilities());
      /*
       * 4. Hier wird die überschriebene allAbilities Methode der Instanz vom Typ Parrot abgerufen. Es wird
       * 	die allAbilities Methode der Superklasse aufgerufen (dynamisch) und dann wird hinter diesem Ergebnis noch das eigene
       * 	ability Attribut der Parrot Klasse gehangen. Die Superklasse des Parrots ist die Bird Klasse (statisch) 
       * 	Rückgabe --> Wert des Attributes von der Klasse Bird (wegen Superklasse) & der Wert
       * 	des Attributes der Parrot Klasse 
       */
      System.out.println("5: parrot.ability                 : " + parrot.ability);
      /*
       * 5. Direkter Zugriff auf die Instanz vom Typ Parrot. An der Instanz wird der Wert
       * 	des public Attribut ability abgerufen und ausgegeben.
       * 	Rückgabe --> Wet des Attribues von der Klasse Parrot --> statisch
       */
      
      Bird carsten = new Dodo();
      /* Dodo carsten = new Bird(); nicht möglich, Substitutionsprinzip */
      
      System.out.println("6: carsten.ability                : " + carsten.ability);
      /*
       * 6. Eine Instanz vom Typ Dodo in einer Variable vom Typ Bird. 
       * 	Rückgabe --> Bei Aufruf des Attributes ability wird jetzt der Wert 
       * 	der Bird Klasse ausgegeben, da immer die Attribute statisch gebunden werden.
       */
      System.out.println("7: ((Bird)carsten).allAbilities() : " + ((Bird) carsten).allAbilities());
      /*
       * 7. Hier wird eine Instanz vom Typ Dodo die in einer Variablen vom Typ Bird ist zu einem Bird gecastet.
       * 	Rückgabe --> Da die Methode stets dynamisch zur Laufzeit gebunden wird,
       * 	das Ergebnis der Methode allAbilities der Klasse Dodo (dort statisch)
       */
      Bird einstein = parrot;
      System.out.println("8: einstein.allAbilities()        : " + einstein.allAbilities());
      /*
       * 8. Hier wird eine Instanz vom Typ Parrot in einer Variable vom Typ Bird gepackt. Der Methodenaufruf
       * 	von allAbilities liefert, da Methoden dynamisch zur Laufzeit gebunden werden, das Ergebnis der Methode
       * 	allAbilities der Klasse Parrot. Das Ergebnis der allAbilities Methode der Klasse Parrot liefert das Ergebnis
       * 	der allAbilities Methode der Superklasse gefolgt von dem Attribut der Klasse Parrot. --> also wie zuvor, innerhalb der Klasse
       * 	statisch
       */
      System.out.println("9: einstein.getAbility()          : " + einstein.getAbility());
      /*
       * 9. Hier wird zunächst nach einer getAbility Methode in der Klasse Parrot gesucht. Da Parrot allerdings die 
       * 	getAbilitty Methode nicht überschreibt, wird das Ergebnis der getAbility Methode der Superklasse geliefert. (dynamisch)
       * 	Rückgabe --> Getabillity von Bird
       */
      System.out.println("10: ((Parrot)einstein).ability    : " + ((Parrot) einstein).ability);
      /*
       * 10. Parrot, wleche in einer Bird Variable ist wird zu einem Parrot gecastett und somit
       *	auch als Parrot aufgefasst. 
       *	Rückgabe --> ability von Parrot (statisch)
       */
   }
}
