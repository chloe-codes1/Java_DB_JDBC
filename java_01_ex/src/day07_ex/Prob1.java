package day07_ex;

public class Prob1 {
/*
	문제1. Prob1내에 leftPad 메쏘드를 작성하십시오. 
	      leftPad 메쏘드의 속성은 다음과 같습니다.

	1.	메소드 시그니처 : 
	        public String leftPad(String str, int size, char padChar)

	2.	입력 문자열(str)의 길이가 입력받은 수(size)가 될 때까지 
	        문자열의 좌측을 지정된 문자(padChar)로 채운 후 리턴한다.

	3.	단, 입력 문자열(str)의 길이가 입력받은 수(size) 보다 
	             큰 경우에는 원본 문자열(str)을 그대로 리턴한다.

	실행 예) 
	leftPad(“bit”, 6, ‘#’)    ###bit 
	leftPad(“bit”, 5, ‘$’)    $$bit
	leftPad(“bit”, 2, ‘&’)    bit
*/
		
		public static void main(String args[]) {
			Prob1 prob1 = new Prob1();
			
			System.out.println( prob1.leftPad("bit", 6, '#') );
			System.out.println( prob1.leftPad("bit", 5, '$') ); 
			System.out.println( prob1.leftPad("bit", 2, '&') ); 
			
		}
		public String leftPad(String str, int size, char padChar) {
			/*  여기에 프로그램을 완성하십시오. */
		
		//처음에 푼 것
		/*
		int nums = str.length();
	
		int times = 0;
		
		int count = size - nums;
	 			
		for(int i = 0 ; i<count ; i++) {
			times++;
			}
			
		
		for(int j=0 ; j<times ; j++) {
			
			System.out.print(padChar);
		}
		
		return str;
		*/
		
		//최종
			int times = str.length();
			for( int i=0; i<size-times ; i++) {
			
				str=padChar+str;
				//for문의 증감식에 str.length()에 str이 들어가는데 아래에서 str의 값이 바뀜
				//그래서 str.length()를 times에 넣어둠!
			}
		return str;
	}
}
