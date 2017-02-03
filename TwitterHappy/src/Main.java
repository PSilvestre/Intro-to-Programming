
public class Main {
	public static void main(String [] args) {
		TwitterHappy tweet = new TwitterHappy();
		
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		tweet.sendMsg('M');
		
		System.out.println("NUM OF MSGS: " + tweet.numberOfMsgs('M'));
		
		System.out.println("IS HAPPY: " + tweet.isHappy());
		
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		tweet.sendMsg('E');
		
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		tweet.sendMsg('A');
		
		System.out.println("IS FULL HAPPY: " + tweet.reachFullHappiness());
		
	}
}
