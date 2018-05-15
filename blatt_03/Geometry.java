package Vererbung;

public abstract class Geometry {

   private int dimension;
<<<<<<< HEAD:blatt_03/Geometry.java
    
=======

   /**
    * Create a new Geometry.
    *
    */
 
>>>>>>> c731e3b63be2b0b2ab345e5f468d9514566c636c:Geometry
   public Geometry(int dimension) {
      if (dimension < 2) {
         throw new RuntimeException("Dimension ist < 2");
      }
      this.dimension = dimension;
   }

<<<<<<< HEAD:blatt_03/Geometry.java
=======
   /**
    * 
    * @return number of dimensions of this Geometry
    */
>>>>>>> c731e3b63be2b0b2ab345e5f468d9514566c636c:Geometry
   public int dimensions() {
      return this.dimension;
   }
    
<<<<<<< HEAD:blatt_03/Geometry.java
   ////// TO IMPLEMENT IN THE CHILDREN ///////////////
   public abstract double volume();

   public abstract Geometry intersect(Geometry other);

    public int compareTo(Object o) {
        return 0;
    }
   ////// TO IMPLEMENT IN THE CHILDREN ///////////////
=======
   /**
    * 
    * @return volume of this Geometry
    */
   public abstract double volume();


   /* Abstrakte Klassen/Methoden: Nicht immer soll eine Klasse sofort ausprogrammiert werden. Zum Beispiel dann nicht, 
    * wenn die Oberklasse lediglich Methoden für die Unterklassen vorgeben möchte, aber nicht weiß, wie sie diese implementieren soll. 
    * In Java gibt es dazu zwei Konzepte: abstrakte Klassen und Schnittstellen (engl. interfaces).
	* Bisher haben wir Vererbung eingesetzt, und jede Klasse konnte Objekte bilden. 
    * Das Bilden von Exemplaren ist allerdings nicht immer sinnvoll, zum Beispiel soll es untersagt werden, wenn eine Klasse 
    * nur als Oberklasse in einer Vererbungshierarchie existieren soll. 
    * Sie kann dann als Modellierungsklasse eine Ist-eine-Art-von-Beziehung ausdrücken und Signaturen für die Unterklassen vorgeben
    */
   public abstract Geometry intersect(Geometry other);


   /**
    * 
    * @param o 
    * @return zero
    */
   public int compareTo(Object o) {
	return 0;
}

>>>>>>> c731e3b63be2b0b2ab345e5f468d9514566c636c:Geometry
}
