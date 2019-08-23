package day02;

public class Test02 {
	public static void main(String[] args) {
							  // 기본형 데이터 (int)
		int num = 99;         //local variable(지역 변수) -> main 함수 안에 있기 때문에
								// 여기서 99를 초기값 이라고 한다!
		System.out.println(num);
		
	
		//String name;
		//System.out.println(name); // 에러뜸!
									//-> local variable은 변수 선언을 하고 초기값을 넣어야 사용할 수 있음
//		String name = null;		//null = String type의 초기값
//		System.out.println(name); // -> null 값을 입력해줘서 에러 안 뜸
				
		
		String name = "홍길동";  // Reference형 데이터
		System.out.println(name.charAt(0)+"**"); // name이 가리키는 곳에서 0번째 문자 하나 꺼내줘
													// 0번 째 위치에 있는 '홍' + ** 출력됨
		
		
		String address = new String("비트교육센터"); //String 은 new로 쓸 수 도 있다  -> 그러면 heap 영역에 저장됨
		System.out.println(address + " : " + address.length()); // address.length() = address가 가리키는 문자열의 사이즈 알려줘
		
		
		long number = 999999999999999999L;  //int가 저장할 수 있는 값보다 큰 숫자는  Long으로 타입 선언 해야함  -> L 빼면 에러 뜸
		System.out.println(number);
		
		System.out.println('a' + " : " + (int)'a'); // a : 97    => (int)'a'로 a의 ASCII Code 값 구했음
		System.out.println('A' + " : " + (int)'A'); // A : 65	=> (int)'A'로 a의 ASCII Code 값 구했음
		
		
	}
}