
public class Company {

	// name der Company
	public String name;

	// parameter für company
	public Company(String cName) {
		this.name = cName;
	}

	// getter
	public String getName() {
		return this.name;
	}
	
	//Ausgabe Name + Preis
	public void changeStockPrice(double price) {
		Ticker.getInstance().print(this.name + price);
	}
	
	//Falls insolvent Ausgabe
	public void insolvent() {
		Ticker.getInstance().print(name + " ist insolvent");
	}
}
