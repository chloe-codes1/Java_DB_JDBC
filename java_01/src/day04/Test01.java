
package day04;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		System.out.println("알파벳 아스키 코드 값 확인");
		
		
		char a = 'a';
		char A = 'A';
		
		for(int i=0 ; i<26 ; i++) {  //z값 까지 나오도록 26번 반복하게 for문 돌림
			
		System.out.println(a + " : " + (int)a++ + ", " + A + " : " + (int)A++);  //아스키 코드값 확인을 원할 땐, (int)로 바꿔주기
																//a++로 a가 b로 바뀌었고, A++로 A가 B로 바뀌었음
			//대문자 -> 소문자 = +32
			//소문자 -> 대문자 = -32
			 
	}
		
		// [문제] 변수 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경하는 코드를 완성합니다.
	
		/*
		char ch = 'A';
		char s = (ch>='A' && ch<='Z') ? (char)(ch+32) : ch;  //char type은 int type으로 promotion이 그대로 일어남
		
		
		System.out.println(ch + " => " +s);
		
		
		char d = (ch>='a' && ch<='z') ? (char)(ch-32) :ch;
		System.out.println(ch + " => " +d);
		*/
		
		
		//문자열 중 대문자는 소문자로, 소문자는 그대로 출력하기
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하면 대문자는 소문자로, 소문자는 그대로 출력합니다");
		String msg = scanner.nextLine();
			
			//문자열은 무조건 문자의 배열로 관라한다!
			//**JAVA에서 배열은 무조건 0번째 Index부터 시작한다!
		
		// if문 사용
		for(int i=0 ; i<msg.length() ;i++) {
			
			char character = msg.charAt(i);
			
	
			if(character>='A' && character<= 'Z') {
				
				character += 32;
				System.out.print((char)character);
			}else {
				
				System.out.print((char)character);
			}
			
		}
		
		// 삼항 연산자 사용
		/*	
		for(int i=0 ; i<msg.length() ; i++) {//문자열의 length를 구하는 함수 => msg.length()  => 문자열 수만큼 i가 증가할 수 있도록 이 함수를 썼음!
		
		char ch = msg.charAt(i);  //.charAt 은 msg가 가리키는 곳의 i번째를 뽑아내라는 함수    => charAt( ) 안의 숫자는 문자열의 length 보다 크면 안된다!
					
		char s = (ch>='A' && ch<='Z') ? (char)(ch+32) : ch;
		
	
		System.out.println(ch + " => " +s);
		 */
		
		System.out.println();
		
	//[과제]
		
		//소문자 -> 대문자
		//대문자 -> 소문자
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하면 대문자는 소문자, 소문자는 대문자로 바꾸어 줍니다.");
		String alp = sc.nextLine();
		
		for(int i=0 ; i< alp.length() ; i++) {
			
			char input = alp.charAt(i);
			
			char cap =  (input>='A' && input<='Z') ? (char)(input+32) : (input>='a' && input<='z') ? (char)(input-32) : input;
			
			System.out.print(cap);
			
		}
	}
}
