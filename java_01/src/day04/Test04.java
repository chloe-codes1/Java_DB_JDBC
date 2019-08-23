package day04;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		/*
		 * [ Array (배열)!!!!!!!!! ] = 같은 타입으로 여러개의 방을 만들어야 하는데 하나의 이름으로 이들을 모두 다룰 수 있게
		 * 하는것
		 * -> 배열은 같은 타입의 기억공간을 하나의 이름으로 모아서 handling 할 수 있는 자료형이다.
		 * -> 위치 첨자가 따라다니는 변수이다.  => 위치 인덱스가 반드시 따라다님
		 * 
		 * [배열] 1. 선언 2. 생성 3. 초기화
		 * 
		 */

		int[] scores; // 배열 선언
					// -> int scores[]; 도 된다~!
		// 배열 선언한 순간 scores는 reference(참조형)가 됨!!

		scores = new int[5]; // 배열 생성
		// "int type으로 10개의 방을 만드세요"
		// new로 만들어진 것 => Heap영역에 저장됨 => JVM이 관리함 -> 기본(defualt) 초기화가 된다!!

		// System.out.println(scores); //-> [I@15db9742 이렇게 주소가 찍힘 (배열이니까)

		for (int i = 0; i < 5; i++) {
			System.out.print(scores[i] + "    ");
		}
		System.out.println();

		String[] names = new String[5]; // 배열 선언
		for (int i = 0; i < 5; i++) {

			System.out.print(names[i] + " ");
		}
	
		System.out.println("\n=======================");
		
		scores[0] = 99;
		scores[1] = 100;
		scores[2] = 88;
		scores[3] = 77;
		scores[4] = 66;
	
		names[0] = "홍길동";
		names[1] = "고길동";
		names[2] = "김주현";
		names[3] = "박길동";
		names[4] = "이길동";
	
	
		double avg = 0.0;   //평균 구하기   -> double 형이라서 0.0으로 초기값 설정
		double sum = 0.0;  //합계 구하기 
		
		
		for(int i=0 ; i <scores.length ; i++ ) { //scores.length => scores 라는 배열의 크기만큼만 커진다
			
			sum += scores[i];   //-> for문에 의해 i가 1씩 커지면서 scores의 모든 방을 호출함
		}
		
		avg = sum/scores.length;
		
		System.out.println(Arrays.toString(scores));  // ****Arrays: 배열 관리를 도와주는 것 ******
		System.out.println(Arrays.toString(names));	  //toString(): 배열 주소를 넘겨주면 문자열로 만드어줌
														//to ~~() 종류 엄청 많은 이유는 어떤 배열이든 넘겨주면 Arrays가 다 처리해줄 수 있어서!
		
		
	// [문제] "홍** 99 평균이상"  이런식으로 배열 전체 출력하기
	
		for(int i=0 ; i<names.length ; i++) {
		
		System.out.println(names[i].charAt(0) + "**  " + scores[i] + 
				(scores[i] >=avg ? " 평균이상" :" 평균이하") );
		}
	}
}
