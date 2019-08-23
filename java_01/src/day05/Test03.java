package day05;

import java.util.Arrays;

public class Test03 {

	public static void main(String[] args) {
	
	// [ .toCharArray ]
	//= char로 배열을 만들어라	
		
		String msg = "hello JAVA ~~~";
		
		char[] character1 = new char[msg.length()];  //msg의 크기만큼 공간 만들어라~
		
		for(int i=0 ; i<msg.length() ; i++) {
			character1[i] = msg.charAt(i);
		}   //-> 여기 3줄이 밑에 1줄로 한번에 표현 가능!!!
			//=> 밑에 한줄로 표현하면 코드 중복을 회피할 수 있다~~~~~
		
		
		char[] character2 = msg.toCharArray();
		//msg라는 String은 class 이기 때문에 data와 method(기능)가 포함됨
		//-> .toCharArray() 라는 함수 사용 가능하다! => char 로 배열을 만들어라~ 라는 함수
		//method의 기능에 위에 3줄로 쓴 코드를 한번에 할 수 있는 toCharArray() 가 있다!
		
		
		//character2 라는 배열의 마지막 위치를 '!'로 바꾸기
		character2[character2.length-1] ='!'; 
		
		
		// [ char 배열 -> 문자열로 형변환 하기 ] 
		//-> String과 char의 배열을 간단하게 양쪽으로 바꿀 수 있다
		
		//new String 이용
		String character3 = new String(character2);
		
		//String.valueOf 이용
		String character4 = String.valueOf(character2);					

		System.out.println(msg);
		System.out.println(Arrays.toString(character1)); // [h, e, l, l, o,  , J, A, V, A,  , ~, ~, ~] => char의 배열로 converting 됨
		System.out.println(Arrays.toString(character2));
		System.out.println(character3); //hello JAVA ~~! => 다시 문자열로 출력 되었음!
		System.out.println(character4);
	}
}
