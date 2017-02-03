import java.util.Scanner;

public class Main {   
	public static final int NUM_OF_SALES = 20;
	public static final int TICKETS_BOUGHT_PER_SALE = 5;

	public static void main(String[] args) {
		ChristmasCircus myCircus = null;
		Scanner in = new Scanner(System.in);
	
		System.out.println("Qual deve ser o preco dos bilhetes? ");
		float ticketPrice = in.nextFloat();
		
	
		System.out.println("Quantas vezes se deve poder reduzir o preço? ");
		int reduceTimes = in.nextInt();
	
		myCircus = new ChristmasCircus(ticketPrice, reduceTimes);
		
		for(int c = 0; c < NUM_OF_SALES; c++){
			System.out.println("Valor a pagar: " + myCircus.buyTickets(TICKETS_BOUGHT_PER_SALE));
		}
	
		System.out.println("\nValor em caixa: " + myCircus.moneyInCash());
		System.out.println("Numero de bilhetes vendidos: " + myCircus.numberOfTickets());
	
		in.close();
	}
	
}
