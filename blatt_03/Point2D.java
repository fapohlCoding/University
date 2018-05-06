package Vererbung;

/**
 * Just a 2-Dimensional Point Object
 */
public class Point2D extends Point {

    private double[] koord;			// zwei double Werte werden in einem Array gespeichert

    /**
     * Initialise the Point with 2 dimensions
     */
    public Point2D(double... x) {  	
        super(x);
        setKoord(x);
    }

    /**
     * Get the coordinates of the point
     */
    public double[] getKoord() {
        return koord;				
    }

    /**
     * Set the coordiantes of the point
     * 
     * @param x the list of coordinates to be given to the point
     */
    public void setKoord(double[] x) {	// Deklarieren der Koordinaten
        this.koord = x;
    }
}
