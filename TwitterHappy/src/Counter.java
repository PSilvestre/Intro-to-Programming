
public class Counter {
	private int state;
	
	public Counter(){
		state = 0;
	}
	
	public void inc(){
		state++;
	}
	
	public void dec(){
		state--;
	}
	
	public int status(){
		return state;
	}
	
	public void reset(){
		state = 0;
	}
	
	
}
