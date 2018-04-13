
public class Fraction {
	
	private int numerator;
	private int denominator;
	
	
	
	public Fraction(int numer, int denum) {
		this.numerator = numer;
		this.denominator = denum;
		
		if(this.denominator == 0) {
			throw new RuntimeException("denominator kann nicht 0 sein!");
		} else {
			int teiler = ggt(numer, denum);
			
		
			this.numerator = numer/teiler;
			this.denominator = denum/teiler;
		}
		}
	//Berechnung größter gemeinsamer Teiler nach dem Euklidischen Algorithmus
	
		public static int ggt(int zahl1, int zahl2) {
			while(zahl2 != 0) {
				if (zahl1 > zahl2) {
					zahl1 = zahl1 - zahl2;
				} else {
					zahl2 = zahl2 - zahl1;
					
				}
			}
			System.out.println(zahl1);	
			return zahl1;
		
		}
	public Fraction(int numer) {
		this(numer, 1);
	}
	
	 public Fraction multiply( int factor ) {
	        Fraction result = new Fraction( this.numerator * factor, this.denominator );
	        return result;
	    }

	    // dasselbe wie oben, aber mit einer Fraction
	    public Fraction multiply( Fraction factor ) {
	        Fraction result = new Fraction( this.numerator * factor.numerator,
	                                      this.denominator * factor.denominator );
	        return result;
	    }

	    // Wir teilen unsere Fraction durch eine Andere, und erzeugen eine neue Fraction
	    public Fraction divide( Fraction divisor ) {
	        // Division ist genau wie multiplication aber in Kreuz
	        // also, wir tauschen den numerator und den denomitanor aus, und
	        // multiplizieren wie üblich
	        Fraction upsideDown = new Fraction( divisor.denominator, divisor.numerator );
	        Fraction result = this.multiply( upsideDown );

	        return result;
	    }

	    // hier brauchen wir eine Schleife, um alle "factors" mit der Fraction
	    // zu miltiplizieren und am Ende wird das Ergebnis "result" zurückgegeben.
	    public Fraction multiply( Fraction... factors ) {
	        Fraction result = new Fraction( this.numerator, this.denominator );

	        for( int i = 0; i < factors.length; i++ ) {
	            result = result.multiply( factors[ i ] );
	        }

	        return result;
	    }

	    // Diese Methode gibt diese Fraction als STRING aus (a / b)
	    public String toString() {
	        String myFraction = "" + this.numerator + "/" + this.denominator;
	        return myFraction;
	    }

	    // Jetzt muss man das alles nur testen!
	}
