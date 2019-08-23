package day17_collection;

public class Test01_generic {

	public static void main(String[] args) {
		
	// [ Generic ]	
		
		Book1 b1 = new Book1("JAVA", 900);
					//price의 data type에 대해 언급하지 않자, 자동으로 object로 처리 됨!
					// -> 현재 Book1의 member variable price는 <T>로 되어있음 => generic
		System.out.println(b1);
		
//		Book<String> b2 = new Book<String>("sql", "700");
		//<T>가 <String> 이라고 언급하자, data type String으로 바뀜!
		// -> 나중에 Book1 class에 <T extends Number>로 바꾸자, String은 Number의 자식이 아니라 에러떠서 주석처리함~
		
		Book1<Double> b2 = new Book1<Double>("sql", new Double(700));
		// -> Double 도 Number의 자식이라 에러 없음!
		System.out.println(b2);
		
		
		Book1<Integer> b3 = new Book1<Integer>("JSP", 1000);
		// 이번에는 <Integer> 라고 언급하자, data type Integer로 바뀌었다!
		//  -> int와 Integer 사이에는 오토박싱-언박싱이 발생해서 입력한 int 1000이 자동으로 처리됨!
		//	   => int는 변수가 있으면 data 값이 들어 있는 것 
		//	   => Integer는 객체 
		//        : 어떤 공간에 Integer class가 올라간 것 => 기능을 쓸 수 있음

		System.out.println(b3);
	}
}
