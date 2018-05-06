package Vererbung;

import javax.management.RuntimeErrorException;

/**
 * Represents a n-dimensional Point of data. 
 */
public class Point extends Geometry {
    // the coordinates that represent this point.
    private double[] koord;
   
	/**
	 * Initialise the point based on a list of coordinates. The length of the list
	 * defines the amount of dimensions of the points
	 */
    public Point( double... liste ){
		super( liste.length );
		this.koord = liste;
    }
	
	/**
	 * Initialise the point just based on the amount of dimensions that it should have
	 * and initialise its coordinates to 0
	 */
    public Point(int n){
		super(n);
		double[] myCoordinates = new double[n];
		for( int i = 0; i < n; i++ ) {
			myCoordinates[i] = 0.0;
		}
		this.koord = myCoordinates;
    }
   
	/**
	 * The default constructor is a 2 dimensional point, with coordinates at 0
	 */
    public Point(){
		super(2);
		setKoord(new double[]{0.0,0.0});
    }

	/**
	 * Returns a Geometry Object that has encapsulated both this and the Geometry other
	 * 
	 * @param other another Geometry with which this will be encapsulated
	 * @return new Geometry another shape that will encapsulate other and this.
	 */
    public Geometry encapsulate(Geometry other) {
		if( super.dimensions() != other.dimensions()) { return null; }
		if( other instanceof Point && this.getKoord().length == 2 ){
			return new Rectangle(new Point2D(getKoord()), 
					new Point2D(((Point)other).getKoord()));
		} else {
			Point[] hut = punkt(other, this );
			return new Volume(hut[0], hut[1]);
			}
	}
	
	/**
	 * Returns a Point[] array punkt that is made with the minimum and maximum values
	 * of the points that were used (in order to be abke to encapsulate)
	 * 
	 * @param other the original Geometry
	 * @param x the other Geometry
	 * @return the already sorted Point[] array, with 2 points being one with min
	 * 			coordinates, and the other one with the max coordinates.
	 */
    public Point[] punkt(Geometry other, Point x) {
			Point a = ((Volume)other).getP1();
			Point b = ((Volume) other).getP2();
			double[] punkt1 = new double[x.dimensions()];
			double[] punkt2 = new double[x.dimensions()];

			for(int i = 0; i < x.dimensions(); i++ ) {
				double[] tmp = selectionSort(a.getKoord()[i], b.getKoord()[i], x.getKoord()[i]);
				punkt1[i]=tmp[0];
				punkt2[i]=tmp[tmp.length-1]; 
			}

			return new Point[]{new Point(punkt1), new Point(punkt2)};	
    }

	/**
	 * Returns the sorted list array from min to max.
	 * @param list the double[] array
	 * @return the list of doubles already sorted from MIN to MAX
	 */
    static double[] selectionSort(double... list) {
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
	
	/**
	 * Returns 0, since a point has no volume
	 * 
	 * @return the volume of the Geometry
	 */
    @Override
    public double volume() {
		return 0;
    }

	/**
	 * Returns the coordinates koord of the point
	 * 
	 * @return the coordinates of the point
	 */
    public double[] getKoord() {
        return koord;
    }

	/**
	 * Sets the coordinates of the point.
	 * 
	 */
    public void setKoord(double... koord) {
		if( this.koord.length > koord.length ) {
			throw new RuntimeErrorException("Too many coordinates. The point has only so many dimensions! " );
		}
		for( int i = 0; i < koor.length; i++ ) {
			this.koord[i] = koord[i];
		}
    }

    @Override
    public int compareTo(Object o) {
		if(o instanceof Point) {
			return 1;
		}
		return -1;
    }

	@Override
	public Geometry intersect(Geometry other) {
		return null;
	}
     
}
