package Suchen;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.Reader;

/**
 *@author FabiP
 */

public class Reader1 extends BufferedReader {

	private int Zaehler;
	private int anzahl;
	private String Zeile;
	private Pattern toMatch;
		
	/**
	 * @param in
	 * Konstruktor, rufen den Konstruktor im BufferedReader auf
	 */
	public Reader1(Reader in) {
		super(in);
		Zaehler = 0;
	}
	
	/**
	 * @param arg0
	 * @param match
	 * Konstruktor mit zwei übergebenen Werten
	 * rufen den anderen Konstrukor auf
	 * compilieren der übergebenen String in ein pattern
	 * kompilieren den match in ein Pattern für getAmountOfMatches()
	 */
	public Reader1(Reader in, String match) {
		this(in);
		this.toMatch = Pattern.compile(match);
	}
	
	/* (non-Javadoc)
	 * @see java.io.BufferedReader#readLine()
	 * überschreiben die Methode der BufferedReader
	 * haben einen Zähler in der ReadLine Methode für die getLineNumber()
	 */
	public String readLine()throws IOException {
		Zaehler++;
		Zeile = super.readLine();
		return Zeile;
	}
	
	/**
	 * @return
	 * Methode die Zeile zurück gibt
	 */
	public int getLineNumber(){
		return Zaehler;
	}
	
	
/*	public int getAmountOfMatches(){
		String [] s = aktuell.split(regex);
		if (aktuell.endsWith(regex))
			anzahl = 1;
		else
		anzahl = 0;
		for(int i = 0; i <= s.length; i++){
			anzahl++;
		}
return anzahl;						
	}*/
	
		
	/**
	 * @return
	 * gibt die Anzahl der Treffer zurück
	 * setzen die Anzahl auf 0
	 * übergeben an die Methode matcher die Zeile und prüfen ob das Wort enthalten ist
	 * dann gehen wir mit der while Schleife durch die Zeile und zählen die gefundenen hoch
	 */
	public int getAmountofMatches() {
		int anzahl=0;
		
		Matcher m1 = toMatch.matcher(Zeile);
		
		while(m1.find()) 
			anzahl++;
		return anzahl;
	}
	
}
