package day13_interface;

import java.util.Calendar;
import java.util.Formatter;

public class Test01_formatter {

	public static void main(String[] args) throws Exception {
	//JAVA에서 제공하는 util 활용하기	
	
		//java.util의 Calendar는 객체 생성이 막혀져 있음 -> new Calendar 안된다!
		//-> Calendar.getInstance() method를 사용해야함!
		// ( Calendar.getInstance() from google)
		//: return a Calendar instance based on the current time in the default time zone with the default locale.
		Calendar c = Calendar.getInstance();
		
		System.out.println(c);
		//Calendar정보를 뽑았는데, 우리가 읽기 힘들게 뜸 
		
		
	// [ String.format ]  -> string class의 format method
		//: 원하는 정보를 원하는 형태로 뽑을 수 있게 해줌
					
		//그럴때 format method와 format 기호를 사용한다!!!
			//시간: %tk  -> 시간의 k만 소문자
			//분: %tM
			//초: %tS
		
		String date = String.format("현재시간은 %tk 시 : %tM 분 : %tS초 %n", c,c,c);
		System.out.println(date);
		
	
	// [ Formatter 활용하기 ] - 207p	
		//: 정보들을 format을 유지하면서 file에 기록하고 싶을 때 주로 사용!
				
		//원주율을 formatter 사용하여 뽑기
		System.out.printf("%f%n", Math.PI);
		String f = String.format("%f", Math.PI);//String.format() method 사용
		System.out.println(f);
		
		System.out.println("--------------------------");
		
		//StringBuffer에는 데이터들을 차곡차곡 모아서 저장이 가능
		StringBuffer sb = new StringBuffer();
		
	// [ Formatter ]
		//Formatter class의 다양한 생성자 활용하여 다양하게 객체 생성하기
		
//		Formatter fm = new Formatter(sb); //StringBuffer로 생성한 formatter
//		Formatter fm = new Formatter(); //default로 생성한 formatter
	
		Formatter fm = new Formatter("sss.txt");
		//여기서 sss.txt는 file이름임
		//-> 에러떠서 main method에 'throws Exception' 추가함
		//-> Exception 발생하면 JVM이 알아서 처리할 것이라는 뜻  => 나중에 예외처리 배우면 처리할것!
		//-> file에 가서 저장하는 작업을 모아서 하기 위해 Buffer에 기록을 해놓고 한번에 저장하기 위해 사용!
		//-> 이렇게 해야 하드디스크에 가서 저장하는 작업 (성능을 떨어뜨리는 작업)을 줄일 수 있다
		
		fm.format("현재시간은 %tk 시 : %tM 분 : %tS초 %n", c,c,c);
					// 이 formatter가 SB에 연결되어 있음
					// ->  sb에 기록이 됨
		
	
	// [ .flush() ]	
	//-> Buffer에 있는 내용을 파일에 가서 저장해라
	//-> 밀어내기!!
	//-> 이걸 해야만 파일에 입력한 내용이 저장됨!	
		fm.flush();
		// 이렇게 한 후에 프로젝트 -> 마우스 오른쪽 -> refresh 하면 방금 만든 파일("sss.txt")가 생성된 것 알 수 있음.
		//-> 눌러보면 입력한 "fm.format("현재시간은 %tk 시 : %tM 분 : %tS초 %n", c,c,c);" 의 출력값 들어가있음
		
		System.out.println("main end");
	}
}
