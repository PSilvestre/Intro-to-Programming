
public class TwitterHappy {
	public static final char MORNING = 'M';
	public static final char AFTERNOON = 'A';
	public static final char EVENING = 'E';
	
	private Counter morning;
	private Counter afternoon;
	private Counter evening;
	
	public TwitterHappy(){
		morning = new Counter();
		afternoon = new Counter();
		evening = new Counter();
	}
	
	public void reset(){
		morning.reset();
		afternoon.reset();
		evening.reset();
	}
	
	public void sendMsg(char dayPeriod){
		switch(dayPeriod){
		case MORNING:
			morning.inc();
			break;
		case AFTERNOON:
			afternoon.inc();
			break;
			
		case EVENING:
			evening.inc();
			break;
		
		}
	}
	
	public int numberOfMsgs(int dayPeriod) {
		switch(dayPeriod){
		case MORNING:
			return morning.status();
			
		case AFTERNOON:
			return afternoon.status();
			
		case EVENING:
			return evening.status();
			
		default:
			return 0;
		}
	}
	
	public boolean isHappy(){
		return (numberOfMsgs(MORNING) + numberOfMsgs(AFTERNOON) + numberOfMsgs(EVENING)) >= 24;
	}
	
	public boolean reachFullHappiness(){
		return (numberOfMsgs(MORNING) >= 8 && numberOfMsgs(AFTERNOON) >= 8 && numberOfMsgs(EVENING) >= 8);
	}
}
