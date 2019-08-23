package day02;

public class Test03 {

	public static void main(String[] args) {
	
		int x = 600, y = 700;
		
		System.out.println("x = " + x + ", y = " + y);
		  // String에서 + 연산은 성능 저하의 원인이 된다.  => 아주 안좋은 코드임! (이렇게 짜면 안됨)
		  // why? String은 Immutable한 (불변의) 객체라서!
		
		  // 그래서 아래처럼 코드를 짜야함.
		System.out.printf("x=%d, y=%d", x, y);   //-> printf 구문에서 f = format 
				//int는 정수형이라서 %d (=decimal)
					// char type 이면 %c
					// String type 이면 %S
					// boolean type 이면 %B
					// float type이면 %F
						//-> 단, 모든 데이터는 String화가 가능하므로 잘 모르겠을 땐 %S 하면 됨~!
		
		x=y;  //y가 가지고 있는 값을 x에 집어넣어라
		System.out.printf("x=%d, y=%d %n", x, y); //그래서 x=700, y=700 이라고 나옴.
		
		//System.out.printf("x=%10d, y=%d %n", x, y);  // %10d 써서 10자리 확보 하고싶을 때      + %n은 줄바꿈
		
		
	//x값과 y값을 바꾸고 싶을 때 (Swapping)
		//-> x값을 임시 공간에 넣어 놓았다가, y값을 x값에 집어넣고나서 임시공간에 있는 x값을 가져와서 y에 넣으면 됨!
		
		int temp;  //임시공간 만들기
		temp = x;	//임시공간에 x값 넣어두기               -> 이 두줄을 int temp = x; 이렇게 써도 됨
		x = y;		//y값을 x에 집어넣기
		y = temp;	// 임시공간에 있는 x값 데려오기
	
		
		System.out.printf("x=%d, y=%d %n", x, y);
		System.out.println("---------------------------");
		
		
		
		
		double d1 = 99.12345, d2=77.12345;
		System.out.printf("d1=%f, d2=%f %n", d1, d2);
		System.out.printf("d1=%5.2f, d2=%5.2f %n", d1, d2);  //%5.2f => 소수점 이하 5자리중에 2자리만 표시해라
		
		
	//(swapping) -> d1값과 d2값 바꾸기
		double space = d1; //임시공간에 d1 넣어놓기
		d1 = d2;			// d2 값을 d1에 넣기	
		d2 = space;			// 임시공간 space에 넣어둔 d1값을 d2로 옮기기
		System.out.printf("d1=%5.1f, d2=%5.1f %n", d1, d2);
		
	}

}
