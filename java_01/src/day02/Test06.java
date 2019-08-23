package day02;

public class Test06 {

	public static void main(String[] args) {
	
	// [ 연산자 ]	
		int num = 100;
		
		System.out.println(num++); //100(101)   -> num++ => 출력시킨 다음에 1을 증가시킴
		System.out.println(num);   //101
		
		System.out.println(++num); //102		-> ++num => 1을 증가시킨 다음에 출력함
		System.out.println(num); //102
		
		System.out.println(6%4);  //2     -> %는 나머지를 구하는 연산자라서 나머지인 2가 출력됨
		
		
		int x=100, y=100;
		System.out.println(x>y);  //false  
		System.out.println(x!=y); //false
		System.out.println(x==y); //true
		
		
	//유효성 검증	
		//score는 0보다 크고 100보다 작아야 한다는 유효성 검증하기
		int score = 99; 
		//boolean result = 0<= score & score<=100;  -> 논리연산자 & 하나도 동작은 되지만, &&을 써야 효율이 높다
		boolean result = 0<= score && score<=100; 
		System.out.println("score 유효성 검증결과 = " + result);
	
	//논리 연산자
		System.out.println(3&4); //and
		// 3 = 00011
		// 4 = 00101
		  // 3&4 = 00000  -> 0
		
	//논리 연산자	
		System.out.println(3|4); //or
		// 3 = 00011
		// 4 = 00101
		  // 3|4 = 00111   -> 7
		
	//시프트 연산자
		System.out.println(4<<2);  //4에서 왼쪽으로 두자리 가라
		 // 00000100 -> 0010000 => 16나옴
		System.out.println(16>>2); //16에서 오른쪽으로 두자리 가라
		 // 0010000  -> 0000100  => 4나옴
		
	}

}
