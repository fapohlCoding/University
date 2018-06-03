package FractionAufgabe;


public class FractionReferenzTest {
	
	public static void main(String[] args) {
		
		
		System.out.println("Teste die Klasse Fraction...\n... Erstelle Fractions...");
		Fraction f1 = Fraction.parseFraction("1/3");
		Fraction f2 = Fraction.parseFraction("1/3");
		Fraction f3 = Fraction.parseFraction("1/4");
		Fraction f4 = Fraction.parseFraction("2/1");
		Fraction f5 = Fraction.newFraction(1, 4);
		Fraction f6 = Fraction.newFraction(2);
		
		
		System.out.println("... Prüfe die Methode parseFraction(String s)...");
		Assert.assertTrue(f1 == f2);
		Assert.assertFalse(f3 == f4);
		System.out.println("... Prüfe die Methode newFraction(int numerator, int denominator)...");
		Assert.assertTrue(f3 == f5);
		Assert.assertFalse(f1 == f5);
		System.out.println("... Prüfe die Methode newFraction(int numerator)...");
		Assert.assertTrue(f4 == f6);
		Assert.assertFalse(f3 == f6);	
		System.out.println("Test abgeschlossen.");

	}
	
}
