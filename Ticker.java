
public class Ticker {

	 // Eine (versteckte) Klassenvariable vom Typ der eigene Klasse
	//b�rsenticker Instanz
	  private static Ticker b�rsenticker;
	  // Verhindere die Erzeugung des Objektes �ber andere Methoden
	  public Ticker() {}
	  
	  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
	  // Objekt erzeugt und dieses zur�ckliefert.
	  // nur ein Objekt kann man erzeugen!
	  // static damit wir nicht nur auf methoden sondern auch auf Klassen aufrufbar
	  public static Ticker getInstance() {
	    if (Ticker.b�rsenticker == null) {
	      Ticker.b�rsenticker = new Ticker();
	    }
	    return Ticker.b�rsenticker;
	  }
	  
	  // %s Platzhalter f�r den String
	  // \n new line 
	  public void print(String text) {
		   String ausgabe=text.replaceAll("\n", "");
		    
		    System.out.printf(" %s +++", ausgabe);
	  }
	}

