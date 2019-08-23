package day07;

public class Calc {
	//instance variable
	//int data=0; 
	
	// class variable  -> class name으로 접근하니까
	static int data=0; // static을 붙이면 접근 가능! -> static은 공유한다는 의미
	
	
	// class method   -> class name으로 접근하니까
	public long add(int a, int b) { //static 처리 하면(= public static long add()를 만들면) memory에 뜸
		
		System.out.println(data);
		// -> 선언부의 static을 빼면 class에 선언된 int data에 접근 가능하나, 선언부에 static 있는 한 에러 뜸
		// => static 안에서는 instance한 자원에 접근 불가 -> instance한 자원은주소를 알아야지만 접근 가능하다!!!
		//    + this keyword 사용 불가
		// 여기서 static 빼면 class안에 있는 static int data에 접근 가능
		// why? instance method는 static한 variable에 접근 가능하기 때문!
		//	    *** static -> instance 접근 불가 ***
		//      *** instance -> static 접근 가능 ***
			//여기서 data는 Calc.data가 생략된거임!
	       //->static에서는 나의 클래스 name으로 정리가 되기 때문에
		
		return a+b; //a+b 라고 안쓰면 오류 뜸
					//why? return; 값이 생략된 void으로 인식하여 선언부의 long과 매치되지 않아서
	}
	
	public static long takeaway(int a, int b) {
		return a-b;
	}
	
	public static long multiple(int a, int b) {
		return a*b;
	}
	
	public static long divide(int a, int b) {
		if(a==0 || b==0) return 0;
		
		return a/b;
	}
}
