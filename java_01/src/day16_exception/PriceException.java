package day16_exception;

import java.io.IOException;

public class PriceException extends IOException {

	// [사용자 정의 예외 class ]
	//  : 이름 정의하고 생성자만 만들었음!
	
	//사용자 정의 exception class를 만들 땐 Exception or IoException 상속 받음!
	
	public PriceException() {
		super("PriceException: 음수는 허용하지 않습니다");
	}			//-> 사용자가 적절히 처리할 수 있는 메세지를 보여주는 것
				//-> 이게바로 예외처리다!
	
	public PriceException(String msg) {
		super(msg);
	}
}
