package day03;

public class Test01 {

	public static void main(String[] args) {
		
	// == : 기본형 (primitive) 데이터 값이 같은지 비교
	// .equals() : 참조형 (reference) 데이터 값이 같은지 비교	
		//-> 주소를 비교하는게 아니라, 주소가 갖고있는 데이터 값이 같은지 비교!!!
		
		
		int num1 = 99;
		int num2 = 99;
		
		String name1 = "홍길동"; //String Type 만 new 안써서 ==랑 .equals() 둘 다 쓸 수 있음
		String name2 = "홍길동";	//-> 그러나 String은 reference가 맞기 때문에 무조건 .equals() 쓰기!
		
		
		String msg1 = new String("Hello");  
		String msg2 = new String("Hello");
		
		System.out.println("num1 == num2 => " + (num1 == num2));
				//=> 뒤에를 괄호로 묶어야 에러가 안남! -> String + int 라서~
				//-> 괄호로 묶어야 뒤에 먼저 연산하고 앞에 연산해서 에러 안난다!
		
		System.out.println("name1 == name2 => " + name1.equals(name2));
				// String은 reference가 맞기 때문에 .equals() 쓴다!
				// 순서 바꿔서 name2.equals(name1) 해도 똑같다~~ 당연히~~
		
		System.out.println("msg1 == msg2 => " + (msg1 == msg2));// false 나옴
																//-> why? 참조형이라서 저렇게 쓰면 주소를 비교하는 거임
		System.out.println("msg1 == msg2 => " + msg1.equals(msg2)); // -> true!
																//이렇게 써야 "msg1이 가리키는 값과 msg2가 가리키는 값이 같니??" 가 됨 

		String msg3 = new String("Hello");  
		String msg4 = new String("Hello Java");
		
		
		msg3 = msg4; //msg4에 기억되는 주소를 msg3에 넣어라
						//-> msg3이 가리키던 주소가 msg4를 가리키게 됨
						//=> msg3이 가리키던 주소는 Garbage의 대상이 된다!!!!!
						//==> 그래서 !에 "the value of the local variable msg3 is not used" 라고 뜸!!
	}
}
