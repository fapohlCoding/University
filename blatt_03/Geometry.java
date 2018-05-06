package Vererbung;

public abstract class Geometry {

   private int dimension;
    
   public Geometry(int dimension) {
      if (dimension < 2) {
         throw new RuntimeException("Dimension ist < 2");
      }
      this.dimension = dimension;
   }

   public int dimensions() {
      return this.dimension;
   }
    
   ////// TO IMPLEMENT IN THE CHILDREN ///////////////
   public abstract double volume();

   public abstract Geometry intersect(Geometry other);

    public int compareTo(Object o) {
        return 0;
    }
   ////// TO IMPLEMENT IN THE CHILDREN ///////////////
}
