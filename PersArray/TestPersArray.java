package PersArray;


import java.util.Arrays;

public class TestPersArray {

	public static void main(String[] args) {

		System.out.println("Wir testen die Funktionen von PersArray...");

		System.out.println();

		Integer[] ary = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Integer[] ary2 = new Integer[ary.length];
		PersArray file = new PersArray("blu", ary);

		System.out.println(" Wir testen die Methoden elem() und getAnzahl()...");

		for (int i = 0; i < file.getAnzahl(); i++) { 						// run file and copy content into ary2
														
			file.setPos(i); // pointer of the actual position
							
			ary2[i] = file.elem(); 	// copy the elemt in ary2 

		}
		System.out.println(Arrays.toString(ary2));

		if (sindGleich(ary, ary2) == true) {
			System.out.println(" --> Methode elem und getAnzahl funktioniert!");

		} else {
			System.out.println(" --> Implementierung von elem und getAnzahl falsch!");
		}

		System.out.println();
		System.out.println("Wir testen die Methoden change...");
		System.out.println("dazu ändern wir im array 7 zu 0");

		Integer[] ary3 = new Integer[ary.length];
		Integer[] ary4 = { 10, 9, 8, 0, 6, 5, 4, 3, 2, 1, 0 };

		file.setPos(3);

		file.change(0);

		for (int i = 0; i < file.getAnzahl(); i++) {

			file.setPos(i);
			ary3[i] = file.elem();

		}
		System.out.println(Arrays.toString(ary3));

		if (sindGleich(ary3, ary4) == true) {
			System.out.println(" --> Methode change funktioniert!");

		} else {
			System.out.println(" --> Implementierung von change falsch!");
		}

	
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Testen nun die Exceptions in den Methoden... ");
		System.out.println();
		
		System.out.println(" ... testen Exceptions in setPos...");
		
		 try {
			 	file.setPos(50);
	            System.out.println("Etwas ist Schiefgelaufen Exception wurde nicht geworfen!");
	         } catch (ArrayIndexOutOfBoundsException e) {

	         }
		
		 
		 
		 System.out.println("..fertig");
			 
	
		
		
	}

	
	
	
	public static boolean sindGleich(Integer[] array1, Integer[] array2) {

		if (array1.length != array2.length) {
			return false;
		} else {

			for (int i = 0; i < array1.length; i++) {
				if (!array1[i].equals(array2[i])) {
					// System.out.println(array1[i]);
					// System.out.println(array2[i]);
					return false;
				}

			}
		}
		return true;
	}
}
