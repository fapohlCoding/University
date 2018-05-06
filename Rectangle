package Vererbung;


public class Rectangle extends Volume {

    private Point2D p1;
    private Point2D p2;

    public Rectangle(Point2D x, Point2D y) {
	super(((Point)x),((Point)y));
	setP1(x);
	setP2(y);
    }

    public Point2D getP1() {
	return p1;
    }

    public void setP1(Point2D p1) {
	this.p1 = p1;
    }

    public Point2D getP2() {
	return p2;
    }

    public void setP2(Point2D p2) {
	this.p2 = p2;
    }

    @Override
    public Geometry encapsulate(Geometry other) {
	if (super.dimensions() != other.dimensions())
	    return null;
	else {
//	    Zum ändern nur Point in Point2D ändern und den Charst rausnehmen
//	    Die Methoden punkt steht in Volume und SelectionSort und Volumen auch
	   if(other instanceof Point){
	       Point[] hut =punkt1(this, (Point)other);
	       return new Volume(((Point) hut[0]), ((Point) hut[1]));
	   }
	    else{
		Point[] hut = punkt(this, other);
	    	return new Volume(hut[0], hut[1]);
	
	    }
    
	}
    }
//    public Point[] punkt(Geometry other, Rectangle x) {
//	Point a = ((Volume) other).getP1();
//	Point b = ((Volume) other).getP2();
//	Point c = x.getP1();
//	Point d = x.getP2();
//	double[] punkt1 = new double[x.dimensions()];
//	double[] punkt2 = new double[x.dimensions()];
//	for (int i = 0; i < x.dimensions(); i++) {
//	    double[] tmp = selectionSort(a.getKoord()[i], b.getKoord()[i],
//		    c.getKoord()[i], d.getKoord()[i]);
//	    punkt1[i] = tmp[0];
//	    punkt2[i] = tmp[tmp.length - 1];
//	}
//	return new Point[] { new Point(punkt1), new Point(punkt2) };
//    }
//
//    static double[] selectionSort(double... list) {
//	double currentMax;
//	int currentMaxIndex;
//
//	for (int i = list.length - 1; i >= 1; i--) {
//	    // Find the maximum in the list[0..i]
//	    currentMax = list[i];
//	    currentMaxIndex = i;
//
//	    for (int j = i - 1; j >= 0; j--) {
//		if (currentMax < list[j]) {
//		    currentMax = list[j];
//		    currentMaxIndex = j;
//		}
//	    }
//
//	    // Swap list[i] with list[currentMaxIndex] if necessary;
//	    if (currentMaxIndex != i) {
//		list[currentMaxIndex] = list[i];
//		list[i] = currentMax;
//	    }
//	}
//	return list;
//    }
//
//    @Override
//    public double volume() {
//	Point a = this.getP1();
//	Point b = this.getP2();
//	double[] punkt1 = {};
//	double[] punkt2 = {};
//	for (int i = 0; i < this.dimensions(); i++) {
//	    double[] tmp = selectionSort(a.getKoord()[i], b.getKoord()[i]);
//	    punkt1[i] = tmp[0];
//	    punkt2[i] = tmp[tmp.length - 1];
//	}
//	double erg=0;
//	for(int i=0; i<punkt1.length;i++){
//	    erg+=(punkt1[i]-punkt2[i]);
//	}
//	return erg;
//    }

}
