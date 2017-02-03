
public class Conversation {
	
	private String conversationHistory;
	private String onGoingConversation;
	private int lastSender;
	private int messageCounter;
	private int tFactor;
	
	
	public Conversation(int tFactor){
		conversationHistory = "";
		clearOnGoingConversation();
		messageCounter = 1;
		this.tFactor = tFactor;
	}
	
	public String getOnGoingConversation(){
		String result;
		
		if(onGoingConversation.equals(""))
			result = "A conversa esta vazia.";
		else
			result = onGoingConversation;
		
		return result;
	}
	
	public String formatMessage(String msg, User sender) {
		return "USER[" + (sender.getUserNumber()) + "]Msg[" + messageCounter + "]: " + msg + "\n";
	}
	
	public void publishNewMessage(String msg, User sender){
		onGoingConversation += formatMessage(msg, sender);
		messageCounter++;
		lastSender = sender.getUserNumber();
	}
	
	public void publishEncryptedMessage(String msg, User sender){
		onGoingConversation += formatMessage(encryptMessage(msg), sender);
		messageCounter++;
	}
	
	public String encryptMessage(String msg){
		String result = "";
		int i = 0;
		while(i < msg.length()){
			
			if(msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z'){
				if(msg.charAt(i) + tFactor > 'z') {
					result +=  (char)(((msg.charAt(i) + tFactor) % 'z') + ('a'-1));
				}else{
					result += (char) (msg.charAt(i) + tFactor);
				}
				
			}else if(msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z'){
				if(msg.charAt(i) + tFactor > 'Z') {
					result +=  (char)(((msg.charAt(i) + tFactor) % 'Z') + ('A' - 1));
				}else{
					result += (char) (msg.charAt(i) + tFactor);
				}
			}else{
				result += msg.charAt(i);
			}
			
			i++;
		}
		return result;
	}
	
	public void clearOnGoingConversation(){
		onGoingConversation = "";
	}
	
	public int getLastSender(){
		return lastSender;
	}
	
	public void substituteLastMessage(int userNumber, String corrected) {
		
		
		
		
		/*String tag = "USER[" + userNumber + "]Msg[" + messageCounter + "]:";
		int lastIndex = onGoingConversation.lastIndexOf(tag) + tag.length();
		onGoingConversation = onGoingConversation.substring(0,lastIndex);
		onGoingConversation += corrected;*/
		
	}
	
	public void endConversation(){
		conversationHistory += "\n**************************\n\n" + onGoingConversation;
		clearOnGoingConversation();
		messageCounter = 1;
	}
	
	public String getConversationHistory(){
		return conversationHistory;
	}
}
