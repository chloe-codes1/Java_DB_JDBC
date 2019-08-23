package day02;

public class Test01 {
	
	//class = data(변수) + 기능(method)
	public static void main(String[] args) {
		
		
	// [ Data Types ]	
		
	int num =99;   //num에는 정수만 들어갈 수 있다고 제한하는 것 & 32bits가 할당됨 (int니까!)
	  //-> 데이터 타입 + 변수명;  이렇게 선언한다
	long num1 = 99L;  // int 를 제외한 data type은 long이면 L 이렇게 써줘야 하는데,
						//long은 int보다 크므로 L안써도 됨(L로 자동 promotion 해줘서)
					  // 단, int의 범위를 초과하는 숫자를 입력하려면 L을 붙여서 long임을 명시해줘야함!
	// byte b1 = 128;  //-> 이렇게 하면 에러 뜸 (byte가 작은 단위라서)
	
	boolean flag = true;

	char c = 'a';   //->' '이렇게 공백이라도 들어가야됨 (비어있으면 안됨)
	
	// float f1 =55.9; //-> 에러 뜸 (double이 기본이라서) -> 웬만하면 double로 써라~
	float f1 = 55.9F; //이렇게 뒤에 f 붙여줘야 함!				==> 캐스팅 (데이터의 손실이 발생하기 때문에 캐스팅 해준다.)
	float f2 = (float)55.9; //이렇게 형 변환도 가능     ==> 이게 바로 type casting!
	
	double d1 = 55.9f; //왼쪽은 double이고 오른쪽은 float인데도 에러 안뜨는 이유 = JAVA는 양쪽을 맞추려고 한다!
						// -> double이 float보다 크기 때문에 데이터의 손실이 발생하지 않아서
							//casting은 필요하지 않고, promotion이 일어나서 에러 안 뜸!
	double d2 = 55.9;
	
	
	char d = 'a'; // 양쪽 다 char type이라서 문제 없음
	
	int e = (int)'a';		// 정수형으로 type casting 해주었음! => 명시적 형변환
		System.out.println(d); //a
		System.out.println(e); //97 
	
		
	int a = 'a'; //'a'가 char인데 오류 안남  -> why?  char type은 int type으로 자동 promotion이 발생함!
	char b = (char)a; 
	
		System.out.println(a); //97
		System.out.println(b); //a
	
	
	}

	}


