package Vererbung;

public class GeometryTest {
    
    public void druck(int a){
	System.out.println("Besitzt "+a+" Dimensionen");
    }
    
    public void druck(double a){
	System.out.println("Das Volumen beträgt: "+a);
    }

    public static void main(String[] args) {
	Point a = new Point(new double[]{2.0,2.0});
	Point b = new Point(new double[]{1.0,1.0,1.0});
	Point c = new Point(new double[]{0.0,0.0,0.0});
	Point2D d = new Point2D(new double[]{0.0,0.0});
	Point2D e = new Point2D(new double[]{1.0,1.0});
	Rectangle r = new Rectangle(e, d);
	Volume v = new Volume(b,c);
	GeometryTest t = new GeometryTest();
	Point f = new Point(new double[]{1.0,1.0,1.0});
	Point g = new Point(new double[]{2.0,2.0,2.0});
	Volume v2 = new Volume(f,g);
	Volume v3 = new Volume(a,e);
	
t.druck(a.dimensions());
t.druck(b.dimensions());
t.druck(c.dimensions());
t.druck(d.dimensions());
t.druck(e.dimensions());
t.druck(r.dimensions());
t.druck(v.dimensions());

	Geometry erg1 = e.encapsulate(a);
	t.druck(((Rectangle)erg1).volume());
	
	Geometry erg11 = a.encapsulate(e);
	t.druck(((Rectangle)erg11).volume());
	
	Geometry erg2 = r.encapsulate(a);
	t.druck(((Volume)erg2).volume());
	
	Geometry erg3 = a.encapsulate(r);
	t.druck((erg3).volume());
	
	Geometry erg4 = r.encapsulate(r);
	t.druck((erg4).volume());
	
	Geometry erg5 = v.encapsulate(b);
	t.druck((erg5).volume());
	
	Geometry erg51 = b.encapsulate(v);
	t.druck((erg51).volume());
	
	Geometry erg6 = v.encapsulate(v2);
	t.druck((erg6).volume());

	Geometry erg7 = r.encapsulate(v3);
	t.druck((erg7).volume());

	Geometry erg71 = v3.encapsulate(r);
	t.druck((erg71).volume());
    }

}
