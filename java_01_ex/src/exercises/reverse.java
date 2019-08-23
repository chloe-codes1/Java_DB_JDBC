package exercises;

public class reverse {

	public static void main(String[] args) {
		System.out.println(reverse("Java Programming"));
		
	}


	public static String reverse(String string) {
		
		StringBuilder builder = new StringBuilder();
		
		String result;
		
		for( int i = string.length()-1 ; i>=0 ; i--) {
			
			builder.append(string.charAt(i));
			
		}result = builder.toString();
		
		return result;
	}
	
	
//	public static String reverse(String str) {
//		
//		StringBuffer sb = new StringBuffer();
//		String reversed;
//			for(int i=str.length()-1 ; i>=0 ;i--) {
//				
//				sb.append(str.charAt(i));
//				
//			}
//		reversed = sb.toString();
//		return reversed;
//	}
	
	
	
}
