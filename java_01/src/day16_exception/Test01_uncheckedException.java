package day16_exception;

import java.util.InputMismatchException;

public class Test01_uncheckedException {

	public static void main(String[] args) {

		System.out.println("*** main start ***");
		
		int a=10, b=0;
		
	// [ 예외 처리 ]
		// : try - catch로 오류 발생 코드를 에워 싸는 것
		// -> try로 오류 발생 line 감싸고, catch (발생한 exception이름  + 변수)
		
		try {
		
		System.out.println(1);	
		System.out.println(a/b); // => 예외 발생
		// -> 이 line 때문에 exception 발생함 
		// -> throws new ArithmeticException() 
		System.out.println(2);
		// -> 바로 윗 line에서 예외가 발생했기 때문에 catch block으로 가기 때문에 이 문장은 출력 안됨!
		} catch (ArithmeticException e) { // -> 예외가 발생하지 않으면 catch {} 은 들어가지 않고 jump 한다
				// [ catch {} block ]
				// : 예외가 발생 했을 때에만 수행하는 문장
			System.out.println("예외 발생" + e.getMessage());
										//getMessage() 하면 예외 발생한 내용 알 수 있음!
			e.printStackTrace();
			//.printStackTrace(); 하면 어떤 예외 발생했는지 자세하게 설명해줌
			// -> main과는 다른 stream에서 출력하기 때문에 이 코드가 출력되는 위치는 바뀜!
			System.out.println();
			System.out.println(3);
		}finally { // -> 예외가 발생하든 발생하지 않든 항상 수행하는 block
				// [ finally {} block ]
				// : 예외 발생 여부에 상관없이 수행되는 문장
				//  -> 항상 수행되기 때문에 자원반납 코드는 finally {} block으로 들어감!
			System.out.println("finally { 항 상 수 행 } ");
		}
		//  => [ ArithmeticException 발생 ]
		//      -> RuntimeException의 자식
		//		-> unchecked exception!
		//         : 예외 처리를 하지 않아도 컴파일 시 에러가 발생하지 않는다
		
		System.out.println("---------------------");
		
		if(b!=0) System.out.println(a/b);
		//위에서는 이 문장으로 발생한 ArithmeticException을 try-catch로 잡았지만,
		//사실 runtime exception은 아예 발생하지 않도록 이렇게 if구문으로 잡도록 코딩을 하는게 적절하다
		
		System.out.println("*** main end ***");
	}
}


	// [Unchecked Exception ]	

	//ArithmeticException ss;
	//NullPointerException nn;
	//IndexOutOfBoundsException ii;