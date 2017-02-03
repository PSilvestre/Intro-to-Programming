import java.util.Scanner;

public class Main {
	
	private static final String VIEW_CONVERSATION = "VCP";
	private static final String PUBLISH_NEW_MESSAGE = "PNM" ;
	private static final String PUBLISH_ENCRYPTED_MESSAGE = "PME";
	private static final String CORRECT_PREVIOUS_MESSAGE = "CMA";
	private static final String END_CONVERSATION = "ECP";
	private static final String SHOW_PREVIOUS_CONVERSATION = "MCA";
	private static final String HELP = "A";
	private static final String EXIT = "S";
	
	private static final int TRANSLATION_FACTOR_MIN = 0;
	private static final int TRANSLATION_FACTOR_MAX = 26;
	
	private static void printMenu(){
		System.out.println(VIEW_CONVERSATION + " ­ Ver a conversa em progresso");
		System.out.println(PUBLISH_NEW_MESSAGE + " ­ Publicar nova mensagem");
		System.out.println(PUBLISH_ENCRYPTED_MESSAGE + " ­ Publicar mensagem encriptada");
		System.out.println(CORRECT_PREVIOUS_MESSAGE + " ­ Corrigir mensagem anterior");
		System.out.println(END_CONVERSATION + " ­ Encerrar conversa em progresso");
		System.out.println(SHOW_PREVIOUS_CONVERSATION + " ­ Mostrar conversas anteriores");
		System.out.println(HELP  + " – Ajuda");
		System.out.println(EXIT + " ­ Sair");
	}
	
	
	private static void processViewConversation(Chat chat){
		System.out.println(chat.getOnGoingConversation());
	}
	
	
	private static void processPublishMessage(Chat chat, Scanner in){
		int userNumber = requestInt("Nº do utilizador: ", in);
		String msg = requestString("Mensagem a enviar: ", in);
		
		chat.publishNewMessage(userNumber, msg);
	}
	
	private static void processPublishEncryptedMessage(Chat chat, Scanner in){
		int userNumber = requestInt("Nº do utilizador: ", in);
		String msg = requestString("Mensagem a enviar: ", in);
		
		chat.publishEncryptedMessage(userNumber, msg);
	}
	
	private static void processCorrectPreviousMessage(Chat chat, Scanner in){
		int userNumber;
		
		do{
			userNumber = requestInt("Nº do utilizador: ", in);
			if(!(userNumber == 1 || userNumber == 2))
				System.out.println("Utilizador desconhecido.");
		}while(!(userNumber == 1 || userNumber == 2));
		
		String msg = requestString("Texto a substituir: ", in);
		if(chat.canSubstituteLastMessage(userNumber)){
			chat.substituteLastMessage(userNumber, msg);
		}else{
			System.out.println("Voce nao pode corrigir a ultima mensagem.");
		}
	}
	
	private static void processEndConversation(Chat chat){
		chat.endConversation();
	}
	
	
	
	private static String readOption(Scanner in) {
		String option;
		System.out.println("> ");
		option = in.nextLine();
		return option;
	}
	
	private static int requestInt(String req, Scanner in){
		System.out.println(req);
		int userInput;
		userInput = in.nextInt();
		in.nextLine();
		return userInput;
	}
	
	private static String requestString(String req, Scanner in){
		System.out.println(req);
		return in.nextLine();
	}
	
	private static void processShowPreviousConversation(Chat chat){
		System.out.println(chat.getPreviousConversation());
	}
	
	public static void main(String[] args){
		boolean finished = false;
		String option;
		Scanner in = new Scanner(System.in);
		
		String name1, name2;
		do{
			name1 = requestString("Nome do Utilizador 1: ", in);
			name2 = requestString("Nome do Utilizador 2: ", in);
			if(name1.equals(name2))
				System.out.println("Utilize nomes diferentes.");
		}while(name1.equals(name2));
		
		int tFactor;
		do{
			tFactor = requestInt("Fator de translacao: ", in);
			if(!(tFactor >= TRANSLATION_FACTOR_MIN && tFactor <= TRANSLATION_FACTOR_MAX))
				System.out.println("Utilize um fator de translacao entre 0 e 26.");
		}while(!(tFactor >= TRANSLATION_FACTOR_MIN  && tFactor <= TRANSLATION_FACTOR_MAX));
		
		Chat chat = new Chat(name1, name2, tFactor);
		
		printMenu();
		while(!finished){
			option = readOption(in);
			
			switch(option.toUpperCase()){
				case VIEW_CONVERSATION:
					processViewConversation(chat);
					break;
				case PUBLISH_NEW_MESSAGE:
					processPublishMessage(chat, in);
					break;
				case PUBLISH_ENCRYPTED_MESSAGE:
					processPublishEncryptedMessage(chat, in);
					break;
				case CORRECT_PREVIOUS_MESSAGE:
					processCorrectPreviousMessage(chat, in);
					break;
				case END_CONVERSATION:
					processEndConversation(chat);
					break;
				case SHOW_PREVIOUS_CONVERSATION:
					processShowPreviousConversation(chat);
					break;
				case HELP:
					printMenu();
					break;
				case EXIT:
					finished = true;
					System.out.println("Aplicacao terminada. Ate a proxima.");
					break ;
				default:	
					System.out.println("Opçao inexistente");
					break;
			}
		}
	}
}
