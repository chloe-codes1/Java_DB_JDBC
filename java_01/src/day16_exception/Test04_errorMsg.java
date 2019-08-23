package day16_exception;

import java.io.IOException;

public class Test04_errorMsg {

	public static void main(String[] args) {
		System.out.println("*** main start ***");
		
		//예외 객체 생성하기
//		throw new RuntimeException("~~~ 예 외 발 생 ~~~");
		// -> (컴파일 통과 후) 비정상 종료 하게 됨
		// -> [ Unchecked Exception ]
		
//		throw new IOException();
		// -> 에러 듬 (컴파일 통과 못함)
		// -> [ Checked Exception ]
	
		
		//Checked Exception에 에러 메세지 등록하기
		try {
			throw new IOException("~~~ 고의로 문제 발생 ~~~");
				//-> 이렇게 에러 메세지를 등록하면 IOException이 던진 error를 catch{} block에서 잡아서
				//    getMessage() method를 통해 무엇 때문에 exception이 발생했는지 출력됨!
				//-> [에러 메세지 등록하기]
		} catch (IOException i) {
			System.out.println(i.getMessage());
		}
		
		//에러 메세지로 사용자에게 에러의 내용 알리기
		int jumsu = 900;
		// -> jumsu를 try {} 안에서 선언하면 scope가 try {} block안에서 끝나서 그 이후에 출력 할 수가 없음! 
		
		try {
			if (!(jumsu>=0 && jumsu<=100))
			throw new IOException("점수가 유효하지 않습니다");
				//-> 점수가 유효하지 않을 때 고의로 예외를 발생시키기
				// -> 정상적으로 수행하기 어려울 때 예외를 발생시켜서 에러 메세지를 뜨게 함
				// -> 사용자가 입력한 데이터가 제대로 되지않아서 내가 원하는 작업을 하지 못할 때,
				//    해당 에러에 맞는 메세지를 전달해서 user가 에러의 이유를 인지 할 수 있게 함
				// 		=> 에러 메세지가 필요한 곳에 잘 들어갈 수 있도록 설계를 해야함!!
		} catch (IOException o) {
			System.out.println(o.getMessage());
		} catch (Exception e) {
			
		} finally {
			System.out.println(jumsu);
		}
		System.out.println("*** main end ***");
	}
}
