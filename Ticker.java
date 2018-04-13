
public class Ticker {

	 // Eine (versteckte) Klassenvariable vom Typ der eigene Klasse
	//b�rsenticker Instanz
	  private static Ticker b�rsenticker;
	  // Verhindere die Erzeugung des Objektes �ber andere Methoden
	  private Ticker () {}
	  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
	  // Objekt erzeugt und dieses zur�ckliefert.
	  // Durch 'synchronized' wird sichergestellt dass diese Methode nur von einem Thread 
	  // zu einer Zeit durchlaufen wird. Der n�chste Thread erh�lt immer eine komplett 
	  // initialisierte Instanz.
	  public static synchronized Ticker getInstance () {
	    if (Ticker.b�rsenticker == null) {
	      Ticker.b�rsenticker = new Ticker ();
	    }
	    return Ticker.b�rsenticker;
	  }
	  public String trennzeichen = "+++";
	  
	  public void print(String text) {
		  System.out.print(trennzeichen + text );
	  }
	}

