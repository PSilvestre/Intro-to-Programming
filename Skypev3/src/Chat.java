
public class Chat { 
	
	private User user1;
	private User user2;
	
	private Conversation conversation;
	
	public Chat(String nameOfUser1, String nameOfUser2, int tFactor){
		user1 = new User(nameOfUser1, 1);
		user2 = new User(nameOfUser2, 2);
		
		conversation = new Conversation(tFactor);
	}
	
	public String getOnGoingConversation(){
		return conversation.getOnGoingConversation();
	}
	
	public void publishNewMessage(int userNumber, String msg){
		//This conversion from userNumber to a user is meant to not limit functionality in the future.
		if(userNumber == user1.getUserNumber())
			conversation.publishNewMessage(msg, user1);
		if(userNumber == user2.getUserNumber())
			conversation.publishNewMessage(msg, user2);
		
	}
	
	public void publishEncryptedMessage(int userNumber, String msg){
		//This conversion from userNumber to a user is meant to not limit functionality in the future.
		if(userNumber == user1.getUserNumber())
			conversation.publishEncryptedMessage(msg, user1);
		if(userNumber == user2.getUserNumber())
			conversation.publishEncryptedMessage(msg, user2);
	}
	
	public boolean canSubstituteLastMessage(int userNumber){
		return userNumber == conversation.getLastSender();
	}
	
	public void substituteLastMessage(int userNumber, String msg){
		conversation.substituteLastMessage(userNumber, msg);
	}
	
	public void endConversation(){
		conversation.endConversation();
	}
	
	public String getPreviousConversation(){
		return "Utilizador 1: " + user1.getName() + "\n" +  "Utilizador 2: " + user2.getName() + "\n\n" + conversation.getConversationHistory();
	}
	
}
