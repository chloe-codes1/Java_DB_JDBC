package day04_ex;

public class Prob3_answer {

	public static void main(String[] args) {

		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";
		
		
		//(char)(' '+3)
		//(char)(' '-3)
	
		//참고 : 문자 'a'의 정수값 97, 'z'의 정수값 122
		
		//프로그램 구현부 시작.
		
		for(int i=0; i<sourceString.length() ; i++) {
			
			char c = sourceString.charAt(i);
			
			if (c=='x' || c=='y' || c=='z') {
				encodedString += (char)(c - 23);
			}if (c == ' ') {
				encodedString += c;  //공백은 더하기 빼기를 할 일이 없으니 그대로 처리해라
			}if(c>= 'a' && c<= 'w') {
				encodedString += (char)(c+3);
			}
			
		
			//switch구문으로도 해보기
			
			
			
			
			
			
			
			
			
			
			
			
		}
	
		
		//프로그램 구현부 끝
		
		System.out.println("암호화 할 문자열 : " + sourceString);
		System.out.println("암호화 된 문자열 : " + encodedString);
		
		

	}

}
