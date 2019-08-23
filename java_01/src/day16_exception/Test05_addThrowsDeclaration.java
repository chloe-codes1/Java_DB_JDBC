package day16_exception;

public class Test05_addThrowsDeclaration {

	public static void main(String[] args) throws InterruptedException  {
		System.out.println("*** main start ***");

		for (int i = 0; i < 10; i++) {
			System.out.println("hello~~~" + i);
			
			// [ surround with try/catch 사용 ]
			// : 자동으로 예외 발생 문장 감싸줌
				
				try {
				// [ Thread class의 sleep() method ]
				// : 내가 지정한 시간동안 일을 하지 않고 쉬게 할 수 있음
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			// [ Add throws declaration 사용 ]
			// : 오류 문장을 포함하고 있는 main method에 throws (예외이름) 을 통해 예외 처리 가능	
				Thread.sleep(500);
		}
		System.out.println("*** main end ***");
	}
}
