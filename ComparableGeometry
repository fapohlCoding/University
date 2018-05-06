package Vererbung;


public abstract class ComparableGeometry extends Geometry implements Comparable {

	

	public ComparableGeometry(int dimension) {
		super(dimension);
	}

	
	public int compareTo(Object o) {
		if (o instanceof Geometry) {
			return (int) ((this.volume() - ((Geometry) o).volume()));
		} else {
			throw new RuntimeException("nononono");
		}
	}

}
