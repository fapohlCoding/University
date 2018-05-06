package Vererbung;

/**
 * Geometry objects that are able to implement Comparable
 */
public abstract class ComparableGeometry extends Geometry implements Comparable {

	/**
	 * Just the default constructor. It will remain equal to the parent, apart from
	 * the comparison methodes
	 */
	public ComparableGeometry(int dimension) {
		super(dimension);
	}

	/**
	 * returns the diference of the volumes of the two geometries that were compared
	 * 
	 * @param o an Object, that needs to be another Geometry
	 * @throws RuntimeException if o is not an instance of Geometry
	 */
	public int compareTo(Object o) {
		if (o instanceof Geometry) {
			return (int) ((this.volume() - ((Geometry) o).volume()));
		} else {
			throw new RuntimeException("nononono");
		}
	}
}
