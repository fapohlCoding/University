package Fibonacci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Class to calculate the Fibonacci number. Uses a HashMap to reduce the
 * calculation cost.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Fibonacci {
	private static HashMap<Integer, Long> fibonacciHash;			// darf nicht final sein, da wir die Hashmap noch weiter bearbeiten
	private static File f = new File("FibonacciHash.ser");			// neues file mit Namen mit .ser für Serialisierung wird angelegt
	
	private static final long serialVersionUID = 1;		// Beim Serialisieren eines Objektes wird auch die serialVersionUID der zugehörigen
														// Klasse mit in die Ausgabedatei geschrieben. Soll das Objekt später deserialisiert
														// werden, so wird die in der Datei gespeicherte serialVersionUID mit der aktuellen
														// serialVersionUID des geladenen Files verglichen. Stimmen beide nicht
														// überein, bricht der Deserialisierungsvorgang ab.

	
	
	
	
//	/**
//	 * Fill HashMap with initial key-value-pairs.
//	 */
//	 static {
//	 fibonacciHash = new HashMap<>();
//	 fibonacciHash.put(0, 0L);
//	 fibonacciHash.put(1, 1L);
//	 }
	/**
	 * Calculates the fibonacci value of n.
	 * 
	 * @param n
	 *            a natural number >= 0 to calculate the fibonacci value of
	 * 
	 * @return fibonacci value of n
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 */
	@SuppressWarnings("unchecked")
	public static long fibonacci(int n) throws IOException,
			ClassNotFoundException {
		if (n < 0) {
			throw new IllegalArgumentException("n = " + n);
		}
		ObjectInputStream ois = null;							// InputStream anfangs leer, da noch nichts ausgelesen
		if (fibonacciHash == null) {							// solange die HashMap leer ist 
			if (!f.exists()) {									// und kein file mit dem selben Namen bisher existiert
				f.createNewFile();								// wird ein neues file angelegt
				fibonacciHash = new HashMap<>();				// zudem wird die Hashmap neu angelegt
				fibonacciHash.put(0, 0L);						// und mit den Schlüsselparren befüllt
				fibonacciHash.put(1, 1L);
			} else {											// sollte die Datei bereits existieren
				try {
					FileInputStream fis = new FileInputStream("FibonacciHash.ser");		// neuen Stream anlegen  
					ois = new ObjectInputStream(fis);								// aus der Datei FibonacciHash lesen 

					if (serialVersionUID == (long) ois.readObject()) {		// Die in der Datei gespeicherte serialVersionUID wird mit der aktuellen vergleichen
					fibonacciHash = (HashMap<Integer, Long>) 				// bei Gleichheit Aufruf der hashmap
					ois.readObject();										// auslesen der objekte
					} else													// sonst Exception werfen, da Versionen nicht übereinstimmen
						throw new IllegalStateException(
								"Versionen stimmen nicht überein");
				} catch (IOException e) {
					throw e;
				} finally {
					ois.close();											// endgültiges schließen des Streams
				}
			}
		}
		return getFibonacci(n);												// Rückgabe der FibZahl in Methode getFibonacci
	}

	private static long getFibonacci(int n) throws IOException {
		long fibonacci = 0L;												// --> Schlüssel initialisieren
		if (fibonacciHash.containsKey(n)) {									
			return fibonacciHash.get(n);									 
		} else {
			long nMinus1 = getFibonacci(n - 1);								
			long nMinus2 = getFibonacci(n - 2);
			fibonacci = nMinus1 + nMinus2;
			fibonacciHash.put(n, fibonacci);								
			writeInFile();													// --> muss nun in das File geschrieben werden 
			return fibonacci;												// Rückgabe der FibZahl 
		}
	}

	private static void writeInFile() throws IOException {					// Methode schreibt VersionID und ergänzte HashMap in das File
		ObjectOutputStream oos = null;										// OutputStream anfangs leer da noch nichts in Datei geschrieben wurde
																			
		try {
			FileOutputStream fos = new FileOutputStream("FibonacciHash.ser");	// Neues FileOutputStream anlegen, um in die Datei schreiben zukönnen
			oos = new ObjectOutputStream(fos);									
			oos.writeObject(serialVersionUID);									// Schreiben die Versionnummer rein	und
			oos.writeObject(fibonacciHash);										// schreiben die ergänzte HashMap rein
		} catch (IOException e) {												
			System.out.println("Fehler");
		} finally {
			
				oos.close();										// schließen die aufgebaute Verbindung zum Stream
		
		}
	
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		if (args.length != 1) {
			printUsage();
		}
		try {
			System.out.println(fibonacci(Integer.parseInt(args[0])));
		} catch (IllegalArgumentException ex) {
			printUsage();
		}
	}

	private static void printUsage() {
		System.out.println("java calc/Fiboncci n");
		System.out.println("n must be a natural number >= 0");
	}
}
