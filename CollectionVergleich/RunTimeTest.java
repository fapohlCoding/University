package CollectionVergleich;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class RunTimeTest {

   public static void main(String[] args) {
	   
	   //*new Lists which we want to test*//
      LinkedList linkedlist = new LinkedList();
      ArrayList arraylist = new ArrayList();
      HashSet hashset = new HashSet();

      CollectionRunTime a = new CollectionRunTime(arraylist,hashset,linkedlist);
      
      //* call the CollectionRuntime *//
      a.printRunTime();

   }
}