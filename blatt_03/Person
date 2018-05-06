package EqualsHashcode;

/**
 * Class representing a Person.
 *
 * @author Mathias Menninghaus
 */
public class Person {

   /**
    * The name of this Person.
    */
   private String name;

   /**
    * Constructor setting the name of this Person.
    *
    * @param name the name of this Person
    */
   public Person(String name) {
      this.name = name;
   }

   /**
    * Returns the name of this Person.
    *
    * @return the name of this Person
    */
   public String getName() {
      return this.name;
   }

   /**
    * A Person can only be equal to another Person with exactly the same name.
    * 
    * 	public static boolean equals(Object a, Object b)
    *                         					
	*
	*	Returns true if the arguments are equal to each other and false otherwise. Consequently,
 	*	if both arguments are null, true is returned and if exactly one argument is null, false 
	*	is returned. Otherwise, equality is determined by using the equals method of the first argument.
    *
    * @param o Object to be compared with
    * @return if this Person is equal to o
    */
   public boolean equals(Object o) {

      if (o == null) {
         return false;
      }

      if (o == this) {
         return true;
      }

      if (o instanceof Person) {
         return this.name.equals(((Person) o).getName());
      }

      return false;
   }

   /**
    * Produces the hash Code for this Person. Which simply is the hashCode of
    * its name.
    * 
    * 	public static int hashCode(Object o)
	*
	*  Returns the hash code of a non-null argument and 0 for a null argument.
	*
	*	Parameters:
    *	o - an object
	*	Returns:
    *	the hash code of a non-null argument and 0 for a null argument
    *
    * @return hashCode of name
    */
   public int hashCode() {
      return this.getName().hashCode();
   }
}

