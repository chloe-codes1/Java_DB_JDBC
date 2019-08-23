package day07_ex;

public class Prob1_answer {

	public String leftPad(String str, int size, char padChar) {
		//instance method
		// -> new로 memory에 올려야지 사용 가능 
		
		if(str.length() > size) {
			return str;
		}
		int count = str.length();
		for(int i=0 ;i<size-count ;i++) {
			str = padChar + str;
		}
			return str;
	}
	
	public String rightPad(String str, int size, char padChar) {
	
		if(str.length() > size) {
			return str;
		}
		int count = str.length();
		for(int i=0 ; i <size - count ; i++) {
			
			str=str + padChar;
		}
			return str;
	}
	
	public static void main(String[] args) {
		
		Prob1_answer p = new Prob1_answer();
		//leftPad랑 rightPad가 instance method라서 new로 memory에 올려서 사용함
		
		System.out.println("-----------leftPad------------");
		
		System.out.println(p.leftPad("bit", 6, '#'));
		System.out.println(p.leftPad("bit", 5, '$'));
		System.out.println(p.leftPad("bit", 2, '&'));
		
		System.out.println("-----------rightPad------------");
		
		System.out.println(p.rightPad("bit", 6, '#'));
		System.out.println(p.rightPad("bit", 5, '$'));
		System.out.println(p.rightPad("bit", 2, '&'));
	}
}
