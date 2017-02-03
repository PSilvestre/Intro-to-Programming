
public class Main {
	
	public static void main (String [] args) {
		String example = "the quick brown fox jumped over the lazy dogs";
		
		System.out.println(bubbleSort(example));
		
	}
	
	public static char[] bubbleSort(String s) {
		char[] finalString = s.toCharArray();
		char temp;
		
		for(int i = 0; i < s.length()-1; i ++) {
			for(int j = 0; j < s.length()-1; j ++) {
				if(finalString[j] > finalString[j+1]){
					temp = finalString[j];
					finalString[j] = finalString[j+1];
					finalString[j+1] = temp;
				}
			}
			
		}
		return finalString;
	}
}
