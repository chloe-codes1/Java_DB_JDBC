package day02;

public class Test04 {

	public static void main(String[] args) { //void는 return하는 값이 없어서 실행만 시킴!!!!!!

		
		//.MAX_VALUE
		System.out.println("int type max value => " +Byte.MAX_VALUE);  // 대문자 Byte로 시작하는 Byte Class
												//-> .은 주소니까 Byte Class에 저장되어있는 Max Value값 확인 가능
		System.out.println("integer type max value => "+Integer.MAX_VALUE);	
												//MAX_VALUE 도 상수화 처리된 변수 (Final variable)
		System.out.println("long type max value => " +Long.MAX_VALUE);		
			
		
		System.out.println(Math.PI);  //PI 값은 절대 변하면 안되기 때문에 상수화 처리됨  => PI값은 변경 불가능 -> final variable
										//-> 이렇게 다 대문자인 변수 = 상수화 처리 된 변수
		
		System.out.println("----------------------");
		
		
		
		//.isDigit() 함수 
		char c ='a';
		System.out.println(c + " 숫자니?" + Character.isDigit(c));
			//Character class에 있는 isDigit이라는 기능을 호출 한 것
				//=> c가 digit(숫자)인지 묻는것 -> c에 있는 'a' 값이 숫자인지 아닌지
				//-> true/false 값을 호출함 => boolean
					//Char라서 Character class인 것임
		
	//****함수는 호출하지 않으면 수행이 되지 않는다!!!!
		
		
		//문자 + 문자   => 문자!
		String ss = "1" + "1"; 
		System.out.println(ss); //"1" + "1" 이라서 결과 "11" 나옴
		
	
		
	// [ Parsing ]
		
		//String 을 int type으로 바꾸기  -> 정수 연산으로 바꾸기
		int s1 = Integer.parseInt("1") + Integer.parseInt("1"); //Integer로 Parse 해줘
		System.out.println(s1);  //정수 연산으로 바뀌어서 결과 1+1=2 나옴
		
		//String 을 double type으로 바꾸기 
		double s2 = Double.parseDouble("1") + Double.parseDouble("1");
		System.out.println(s2);
		
		//String 을 float type으로 바꾸기
		float s3 = Float.parseFloat("1.2")+ Float.parseFloat("1.3");   // 함수 호출 문장
				//-> Float Class 안에 있는 parseFloat이라는 method가 있는데 , ex)"1.2"를 호출하면 Float type으로  값을 return 하는 함수 
		
		          //그래서	1.2가 return됨		1.3이 return 됨   (return type)
		System.out.println(s3);
		
					
					//**이런식으로 parseByte, parseLong 등의 API가 설정되어 있음
		
	}

}
