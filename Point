package Vererbung;

public class Point extends Geometry {
    
    private double[] koord;
//    Nicht elegant, da wir nur eine REferenz bekommen und jeder noch auf dem
//    Original arbeiten kann. Wie bekomme ich eine Anzahl an Double in einem
//    Array direkt an den Konstruktor übergeben?
//    Lösung, damit da (double... liste) steht
    
    public Point(double[] liste){
	super(liste.length);
	this.koord=liste;
    }
    
    public Point(int n){
	super(n);
    }
    
    public Point(){
	super(2);
	setKoord(new double[]{0.0,0.0});
    }
//    public void idiot(){
//	throw new RuntimeException("Idiot");
//    }

    public Geometry encapsulate(Geometry other) {
	if(super.dimensions()!=other.dimensions())return null;
	if(other instanceof Point && this.getKoord().length==2)
		return new Rectangle(new Point2D(getKoord()), 
				new Point2D(((Point)other).getKoord()));
	else{
	    Point[] hut=punkt(other, this );
	    return new Volume(hut[0], hut[1]);
	    }
    }
//    Siehe Volumen
    public Point[] punkt(Geometry other, Point x) {
	Point a = ((Volume)other).getP1();
	Point b = ((Volume) other).getP2();
	double[] punkt1=new double[x.dimensions()];
	double[] punkt2=new double[x.dimensions()];
	for(int i=0; i<x.dimensions(); i++){
	    double[] tmp=selectionSort(a.getKoord()[i], b.getKoord()[i], x.getKoord()[i]);
	    punkt1[i]=tmp[0];
	    punkt2[i]=tmp[tmp.length-1]; 
	}
	return new Point[]{new Point(punkt1), new Point(punkt2)};	
    }

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
    
    @Override
    public double volume() {
	return 0;
    }

    public double[] getKoord() {
        return koord;
    }

    public void setKoord(double[] koord) {
        this.koord = koord;
    }

    @Override
    public int compareTo(Object o) {
	if(o instanceof Point) {
	return 1;}
	return -1;
    }

	@Override
	public Geometry intersect(Geometry other) {
		// TODO Auto-generated method stub
		return null;
	}
     
}
