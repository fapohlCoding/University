
public class Ticker {

	 // Eine (versteckte) Klassenvariable vom Typ der eigene Klasse
	//börsenticker Instanz
	  private static Ticker börsenticker;
	  // Verhindere die Erzeugung des Objektes über andere Methoden
	  private Ticker () {}
	  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
	  // Objekt erzeugt und dieses zurückliefert.
	  // Durch 'synchronized' wird sichergestellt dass diese Methode nur von einem Thread 
	  // zu einer Zeit durchlaufen wird. Der nächste Thread erhält immer eine komplett 
	  // initialisierte Instanz.
	  public static synchronized Ticker getInstance () {
	    if (Ticker.börsenticker == null) {
	      Ticker.börsenticker = new Ticker ();
	    }
	    return Ticker.börsenticker;
	  }
	  public String trennzeichen = "+++";
	  
	  public void print(String text) {
		  System.out.print(trennzeichen + text );
	  }
	}

