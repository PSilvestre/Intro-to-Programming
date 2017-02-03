
public class LemonadeStand {
	
	public static final int MAX_LEMONS = 50;
	public static final int MAX_SUGAR = 5000;
	public static final int MAX_WATER = 30;
	
	public static final int LEMONS_PER_JAR = 5;
	public static final int SUGAR_PER_JAR = 5;
	public static final int WATER_PER_JAR = 5;
	
	public static final int CUPS_PER_JAR = 5;
	
	public static final float NORMAL_PRICE = 0.75f;
	public static final float DISCOUNT_PRICE = 0.65f;
	
	public static final float MIN_CUPS_FOR_DISCOUNT = 5;
	
	
	private int lemonsInStock; //in units
	private int sugarInStock; //in grams
	private int waterInStock; //in liters
	
	private int cupsReady;
	
	private int cupsSoldNormal;
	private int cupsSoldBatch;
	
	private int jarsNeeded;
	
	boolean cantServe;
	
	LemonadeStand(){
		lemonsInStock = MAX_LEMONS;
		sugarInStock = MAX_SUGAR;
		waterInStock = MAX_WATER;
		
		jarsNeeded = 0;
		cantServe = false;
		cupsReady = 0;
		
	}
	
	public boolean haveEnough(int jarsNeeded) {
		return (this.getLemonsInStock() > jarsNeeded * LEMONS_PER_JAR) && 
				(this.getSugarInStock() > jarsNeeded * SUGAR_PER_JAR) && 
				(this.getWaterInStock() > jarsNeeded * WATER_PER_JAR);
	}
	
	public void purchase(int cupsBought) {
		if ( cupsReady >= cupsBought) {
			jarsNeeded = 0;
			cupsReady -= cupsBought;
		} else {
			jarsNeeded = cupsBought / CUPS_PER_JAR;
			if(cupsBought % CUPS_PER_JAR != 0)
				jarsNeeded++;
		
			System.out.println("jarsNeeded " + jarsNeeded);
			if(cantServe){
				System.out.println("I cant serve that much!");
				cantServe = false;
			} else {
				if(haveEnough(jarsNeeded)){
					lemonsInStock -= jarsNeeded * LEMONS_PER_JAR;
					sugarInStock -= jarsNeeded * SUGAR_PER_JAR;
					waterInStock -= jarsNeeded * WATER_PER_JAR;
					
					cupsReady += jarsNeeded * CUPS_PER_JAR;
					
					cupsReady -= cupsBought;
					
					System.out.println("Sold " + cupsBought + " Cups!!!");
					if(cupsBought < MIN_CUPS_FOR_DISCOUNT) {
						cupsSoldNormal += cupsBought;
					} else {
						cupsSoldBatch += cupsBought;
					}
				} else {
					System.out.println("Let me just order some more ingredients!");
					reffilStock();
					cantServe = true;
					purchase(cupsBought);
				}
			}
		
		}
	}
	
	
	
	public void reffilStock() {
		lemonsInStock = MAX_LEMONS;
		waterInStock = MAX_WATER;
		sugarInStock = MAX_SUGAR;
	}
	
	public int getCupsReady(){
		return cupsReady;
	}
	
	public float getDatMoney(){
		return NORMAL_PRICE * cupsSoldNormal + DISCOUNT_PRICE * cupsSoldBatch;
	}
	
	public int getLemonsInStock() {
		return lemonsInStock;
	}
	
	public int getSugarInStock() {
		return sugarInStock;
	}
	
	public int getWaterInStock() {
		return waterInStock;
	}
	
	
}
