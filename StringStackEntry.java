/**
 * Represents an entry of a <code>StringStack</code> which holds a String and a
 * reference to the next StringStackEntry.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
class StringStackEntry {
   
   //constructor
	StringStackEntry(StringStackEntry kopie){
		this.s = new String(kopie.s);
		if(kopie.equals ("null"){
			throw new RuntimeException("leer"");
		}
		else {
			this.next = new.StringStackEntry(toCopy.next);
		}
	}
	/**
    * The next StringStackEntry
    */
   private StringStackEntry next;
   /**
    * The String which this StringStackEntry represents
    */
   private String s;

   /**
    * @param s
    *           String in Stack which is represented by this StringStackEntry
    */
   StringStackEntry(String s) {
      this(s, null);
   }

   /**
    * 
    * @param s
    *           String in Stack which is represented by this StringStackEntry
    * @param next
    *           the StringStackEntry next will be visible if this
    *           StringStackEntry is removed from the stack.
    */
   StringStackEntry(String s, StringStackEntry next) {
      this.s = s;
      this.next = next;
   }

   StringStackEntry getNext() {
      return this.next;
   }

   String getString() {
      return this.s;
   }
}
