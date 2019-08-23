package day04_ex;

public class Prob4 {

	public static void main(String[] args) {

		// [문제1]

		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";
		

		for (int i = 0; i < sourceString.length(); i++) {
			
			char ch = sourceString.toUpperCase().charAt(i);
				//입력값 대소문자 구분 없이 계산하기 위해 .toUpperCase() 사용

			if (ch >= 'A' && ch <= 'W') {
				encodedString += (char) (ch + 3);  //문자에다가 +3을 한 순간 int가 되므로 char type으로 casting 했음
			} else if (ch >= 'X' && ch <= 'Z') {
				encodedString += (char) (ch - 23);  //x,y,z는 a,b,c로 바뀌어야 하므로 -23
			} else
				encodedString += ch;
		}

		// 프로그램을 구현부 시작.
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다.

		// 프로그램 구현부 끝.

		System.out.println("암호화 할 문자열 : " + sourceString);
		System.out.println("암호화 된 문자열 : " + encodedString.toLowerCase());
											//.toLowerCase()로 다시 소문자로 변경하여 출력
		System.out.println("-----------------------------------------------------------");

		
		
		// [문제 2]
		// 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 의 결과를 계산하시오
		
		int a, b, i, j, sum = 0;

		for (i = 1; i <= 10; i++) {
			for (j = 1; j <= i; j++) {
				sum = sum + j;
			}
		}
		System.out.println(sum);

		
		//[문제3]
		// 오른쪽이 축인 직각삼각형 찍기

		for (i = 1; i <= 10; i++) {
			for (j = 10; j >= i; j--) {
				System.out.print(" ");
			}
			for (a = 1; a <= i; a++) {
				System.out.print("*");
			}
			System.out.println();
		}

		
		// [문제4]
		// 정삼각형 찍기
		
		for (i = 1; i <= 10; i++) {

			for (j = 9; j >= i; j--) {

				System.out.print(" ");
			}
			for (a = 1 ; a<=i; a++) { 
				System.out.print("*");
			}
			for(b = 1; b<i ; b++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}