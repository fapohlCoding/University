package Vererbung;

public class Volume extends Geometry implements Comparable {

    private Point p1;				// Volume kann durch zwei n dimensionale punkte erzeugt werden
    private Point p2;

    public Volume(Point x, Point y) {
	super(x.dimensions() < y.dimensions() ? y.dimensions() : x.dimensions()); // wenn die Dimensionen der Punkte unterschiedlich sind wird der größere an den Oberklassenkonstruktor übergeben
	setP1(x);
	setP2(y);
    }

    public Point getP1() {
	return p1;
    }

    public void setP1(Point p1) {
	this.p1 = p1;
    }

    public Point getP2() {
	return p2;
    }

    public void setP2(Point p2) {
	this.p2 = p2;
    }

    public Geometry encapsulate(Geometry other) { 			
	if (super.dimensions() != other.dimensions())  // If other and this have a different number of dimensions null is returned.
	    return null;
	else {
	    if (other instanceof Point) {			//  wenn die übergebene geometry ein objekt vom typ point ist
		Point[] hut = punkt1(this, (Point) other);	// neues array aus punkten   ist gleich =      übergeben der methode punkt1  (zu Point gecastete other und  sich selbst)
		return new Volume(hut[0], hut[1]);			// zurückgegeben werden zwei Objekte vom Typ Point, mit jeweils den Eckpunkten
	    } else {
		Point[] hut = punkt(this, other);			// Für denn Fall das es keine Instanz vom Typ Point ist 
		return new Volume(hut[0], hut[1]);			// Methodenaufruf ohne zu casten
	    }
	}
    }

    
    
   /*		---------
    *   	|		|
    *   	|		|
    * 		|		|
    * 		---------
    * 
    * 
    * 
    * 					---------
    * 					|		|
    * 					|		|
    * 					|		|
    * 					---------
    */
   
      
   
    
    public Point[] punkt(Volume x, Geometry other) {	//  Für den Fall das wir 4 eckpunkte haben die sortiert werden müssen 
	Point a = ((Volume) other).getP1();					// 	müssen other zu volume casten um eckepunkte rauszuholen
	Point b = ((Volume) other).getP2();
	Point c = ((Volume) x).getP1();						
	Point d = ((Volume) x).getP2();
	double[] punkt1 = new double[x.dimensions()];		//	ein array aus doublen mit der größe der volumedimension wird erstellt
	double[] punkt2 = new double[x.dimensions()];		//	beide arrays dienen zur speicherung der x bzw y koordinaten
	
	
	
	
	
	// Nimmt sich pro Dimension aus allen den vier Punkten den Wert heraus
	// und sortiert diese. Von den sortierten Werten, wird dann der
	// Größte(vorderer Wert)
	// in das Array punkt 1 gepackt und der kleinste(letzte Wert) in das
	// Andere
	
	for (int i = 0; i < x.dimensions(); i++) {
	    double[] tmp = selectionSort(a.getKoord()[i], b.getKoord()[i],			
		    c.getKoord()[i], d.getKoord()[i]);									
	    punkt1[i] = tmp[0];														
	    punkt2[i] = tmp[tmp.length - 1];
	}
	
	
	// Gibt dann ein Point Array aus, wobei Punkt 1 alle maximalen Werte und
	// punkt2 alle minimalen Werte enthält
	
	return new Point[] { new Point(punkt1), new Point(punkt2) };
    }
    
    
    
    

    // Das gleiche nur mit drei Punkten, bei einem Point und einem Volumen
    
    
    public Point[] punkt1(Geometry other, Point x) {	
	Point a = ((Volume) other).getP1();
	Point b = ((Volume) other).getP2();
	double[] punkt1 = new double[x.dimensions()];
	double[] punkt2 = new double[x.dimensions()];
	for (int i = 0; i < x.dimensions(); i++) {
	    double[] tmp = selectionSort(a.getKoord()[i], b.getKoord()[i],
		    x.getKoord()[i]);
	    punkt1[i] = tmp[0];
	    punkt2[i] = tmp[tmp.length - 1];
	}
	return new Point[] { new Point(punkt1), new Point(punkt2) };
    }

    
    
    
    /**
     * 
     * Selection Sort wie bekannt
     * Kriegt ein array aus double übergeben und gibt ein sortiertes array zurück
     * 
     * @param list
     * @return
     */
    
    static double[] selectionSort(double... list) {
	// Soriert das Array und gibt, so hoffe ich, an erster Stelle das größte
	// und an letzter Stelle das kleinste Ergebnis aus
	double currentMax;
	int currentMaxIndex;

	for (int i = list.length - 1; i >= 1; i--) {
	    // Find the maximum in the list[0..i]
	    currentMax = list[i];
	    currentMaxIndex = i;

	    for (int j = i - 1; j >= 0; j--) {
		if (currentMax < list[j]) {
		    currentMax = list[j];
		    currentMaxIndex = j;
		}
	    }

	    // Swap list[i] with list[currentMaxIndex] if necessary;
	    if (currentMaxIndex != i) {
		list[currentMaxIndex] = list[i];
		list[i] = currentMax;
	    }
	}
	return list;
    }

    @Override
    public double volume() {
	// Methode multipliziert jede Tiefe auf und gibt dann das Ergebnis aus
	// erg=a*b*c*....
	Point a = this.getP1();
	Point b = this.getP2();
	double[] punkt1 = new double[this.dimensions()];
	double[] punkt2 = new double[this.dimensions()];
	for (int i = 0; i < this.dimensions(); i++) {
	    double[] tmp = selectionSort(a.getKoord()[i], b.getKoord()[i]);
	    // System.out.println("Hier"+i);
	    punkt1[i] = tmp[0];
	    punkt2[i] = tmp[tmp.length - 1];
	}
	double erg = 1;
	for (int i = 0; i < punkt1.length; i++) {
	    erg *= (punkt1[i] - punkt2[i]);
	}
	if (erg < 0)
	    erg *= -1;
	return erg;
    }

    @Override
    public int compareTo(Object o) {
	if (o instanceof Geometry) {
	    if (o instanceof Point) {
		    return 0;
	    } else if (o instanceof Volume) {
		if (this.volume() == ((Volume) o).volume())
		    return 1;
	    }
	}
	return 0;
    }
}
