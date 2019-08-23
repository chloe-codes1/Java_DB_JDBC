package day03;

public class Test04 {

	public static void main(String[] args) {

//		System.out.println("Hello JAVA 1");
//		System.out.println("Hello JAVA 2");
//		System.out.println("Hello JAVA 3");
		// 코드 중복이 일어나고있음!!!! -> 반드시 회피해야한다!!!

		
	// [ for문 ]

		// for (초기값 ; 조건식 ; 증감식) { }

		int i;
		for (i = 1; i < 10; i++) {  //여기서 for문 안에서 int i=1로 선언하면, for문이 끝나면{} int i는 더이상 사용할 수 없다!
			System.out.println("Hello JAVA " + i);
		}

		System.out.println(i);
		
		
	// [ while문 ]

		// while (조건식) { 수행문; }
		
		int j = 10;
		while (j > 0) {
			System.out.println("while " + j);
			j--; //여기서 마지막에 j는 0이 되고, while문에 위배되므로 아래로 내려감

		}

		boolean flag = true;
		while (flag) {
			j++; //여기서 0이었던 j는 1이 됨
			System.out.println("~~~~~~ " + j);
			if (j == 5)
				flag = !flag; // j가 5가 되었을 때 not flag => false로 바뀜
		}

		System.out.println("j 값은 " + j); //j가 5일 때 while문을 빠져나왔으니까 j=5
	
	
		while(j<5) {
			System.out.println("do while");  //동작 x -> j=5라서 while문의 j<5에 위배되니까!
														//=> 조건에 만족하지 않음
		}
		
		System.out.println("---------------------");
		
		
	//do-while문
		//=> 조건에 만족하지 않아도 꼭 1번은 실행하고 싶을 때 사용!
		
		do {
			System.out.println("do while");
		}while(j<5); //do while 출력됨   => 일단 실행해서 출력한 후에 while문의 조건에 만족하지 않아서 종료됨
		
	}
}