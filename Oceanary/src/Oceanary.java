
public class Oceanary {
	public static final float DISCOUNT = 0.8f;
	
	private int maxPermTickets;
	private int maxTempTickets;
	
	private int soldPermTickets;
	private int soldTempTickets;
	private int soldTempTicketsDiscount;
	
	private int permPrice;
	private int tempPrice;
	
	public Oceanary(){
		maxPermTickets = 4000;
		maxTempTickets = 500;
		
		permPrice = 15;
		tempPrice = 5;
		
		soldPermTickets = 0;
		soldTempTickets = 0;
		soldTempTicketsDiscount = 0;
	}
	
	public Oceanary(int maxPermTickets, int maxTempTickets, int permPrice, int tempPrice){
		this.maxPermTickets = maxPermTickets;
		this.maxTempTickets = maxTempTickets;
		this.permPrice = permPrice;
		this.tempPrice = tempPrice;
		
		soldPermTickets = 0;
		soldTempTickets = 0;
		soldTempTicketsDiscount = 0;
	}
	
	public int cash(){
		return (int)(soldPermTickets * permPrice + soldTempTickets * tempPrice + soldTempTicketsDiscount * Math.round(0.8 * tempPrice));
	}
	
	public int permanentExhibitionVisitors(){
		return soldPermTickets;
	}
	
	public int  temporaryExhibitionVisitors(){
		return soldTempTickets + soldTempTicketsDiscount;
	}
	
	public int saleValue(int permanent, int temporary) {
		int total = 0;
		
		total += permanent * permPrice;
		
		if(temporary > 0 && permanent > 0){
			total += temporary * tempPrice;
		}else{
			total += temporary * Math.round(tempPrice * 0.8);
		}
		
		return total;
	}
	
	public boolean sale(int permanent, int temporary) {
		boolean canSell = (permanent <= (maxPermTickets - soldPermTickets) && temporary <= (maxTempTickets - (soldTempTickets + soldTempTicketsDiscount)));
		
		if(canSell){
			if(temporary > 0 && permanent > 0){
				soldTempTicketsDiscount += temporary;
			} else {
				soldTempTickets += temporary;
			}
			soldPermTickets += permanent;
		}
		
		return canSell;
	}
	
	
}
