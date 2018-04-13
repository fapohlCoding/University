
public class CompanyTest {
public static void main( String[] args) {
	Company c[] = new Company[3];
	for (int i = 0; i < c.length; i++) {
		c[i] = new Company("Toto" + i);
	}
}

}
