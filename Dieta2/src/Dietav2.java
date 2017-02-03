
public class Dietav2 {
	
	
	
	private int ingestedCalories;
	private int burnedCalories;
	
	private int timesEaten;
	private int timesBurned;
	
	private int mostEatenCalories;
	private int mostBurnedCalories;
	
	Dietav2(){
		ingestedCalories = 0;
		burnedCalories = 0;
		
		timesEaten = 0;
		timesBurned = 0;
		
		mostEatenCalories = 0;
		mostBurnedCalories = 0;
		
	}
	
	public void eat(int c) {
		ingestedCalories += c;
		
		if(c > mostEatenCalories) {
			mostEatenCalories = c;
		}
	}
	
	public void burn(int c) {
		burnedCalories += c;
		
		if(c > mostBurnedCalories) {
			mostBurnedCalories = c;
		}
	}
	
	public int getTimesEaten() {
		return timesEaten;
	}
	
	public int getTimesBurned() {
		return timesBurned;
	}
	
	public int getBalance() {
		return ingestedCalories - burnedCalories;
	}
	
	public boolean isBalanceNegative(){
		return getBalance() < 0;
	}
	
	public float averageEatenCalories(){
		return (ingestedCalories / timesEaten);
	}
	
	public float averageBurnedCalories(){
		return (burnedCalories / timesBurned);
	}
	
	public int mostEatenCalories(){
		return mostEatenCalories;
	}
	
	public int mostBurnedCalories(){
		return mostBurnedCalories;
	}

}
