package Vererbung;

/**
 * The representation of an object through 2 Points
 */
public class Volume extends Point implements Comparable {
	// The defining points
    private Point p1;
    private Point p2;

	/**
	 * The main constructor defines the Volume through two points x and y. It
	 * sets the values of p1 and p2
	 * 
	 * @param x a Point Object
	 * @param y another Point Object
	 */
    public Volume(Point x, Point y) {
		super(x.dimensions() < y.dimensions() ? y.dimensions() : x.dimensions());
		// wenn die Dimensionen der Punkte unterschiedlich sind wird der größere an den Oberklassenkonstruktor übergeben
		setP1(x);
		setP2(y);
    }

	/**
	 * Get the value of the first defining point p1
	 */
    public Point getP1() {
		return p1;
    }

	/**
	 * Set the value for the first defining point p1
	 */
    public void setP1(Point p1) {
		this.p1 = p1;
    }

	/**
	 * Get the value of the second defining point p2
	 */
    public Point getP2() {
		return p2;
    }

	/**
	 * Set the value for the second defining point p2
	 */
    public void setP2(Point p2) {
		this.p2 = p2;
    }

	/**
	 * 
	 */
    public geometry encapsulate(Geometry other) { 
		super.encapsulate( other );
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
