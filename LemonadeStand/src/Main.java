
public class Main {
	public static void main(String[] args) {
		LemonadeStand stand = new LemonadeStand();
		
		stand.purchase(4);
		
		System.out.println("Lemons In stock: " + stand.getLemonsInStock());
	}
}
