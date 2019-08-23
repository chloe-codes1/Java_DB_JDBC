package day02;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
	//초기값 설정하기
		//String name = null; //null로 초기값 설정하지 않으면 에러 뜸 -> method 안에 있기 때문에
		//int score = 0;		//0으로 초기값 설정했음
		
		
	//Scanner
		Scanner input = new Scanner(System.in);  //new는 Heap영역에 메모리가 올라감
		
		System.out.println("학생 이름을 입력하세요");
		String name = input.nextLine();      
		
		System.out.println("점수를 입력하세요 :ex) 90");
		int score = input.nextInt();		
		
		
		
		System.out.printf("이름 : %s, 점수 : %d %n", name, score);
	
		
		
		input.close();  // 이렇게 null assign 하기 전에 close를 시켜야 null assign을 통해 자원 반납이 됨
		input = null; 
		  //-> 참조형에 null assign을 하고 나면 더이상 dot 연산자를 쓸 수 없다!!!!
		
	}

}
