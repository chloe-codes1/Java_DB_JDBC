package day09;

import java.util.Date;

public class Test03 {

	public static void main(String[] args) {

		//매우 안좋은 코드!!!!!!!!!
		String msg = "";
		msg = msg + "hello "+ new java.util.Date() + " java" + " test";
		System.out.println(msg);
		//그래서 StringBuffer로 뽑을 거다
		
		
	// [ StringBuffer ]
		//string에서 plus(+) 연산을 많이 써야할 때 사용
		//StringBuffer 객체에 인자로 전달된 것을 덧붙이는 형식!
		
		String msg1 = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello ");
		sb.append(new Date());
		sb.append(" java");
		sb.append(" test ");
		sb.append('A');
		sb.append(" ");
		sb.append(95);
		
	//String과 StringBuffer는 다른 type임을 아래로 확인 가능 => type을 바꿔서 덧붙여야함
		//msg1 = sb;
		
	// [ .toString() ]	
		//.toString()으로 StringBuffer를 String으로 바꾸기
		//msg1 =sb.toString();
		
		//생성자 함수를 이용해서도 String으로 바꿀 수 있음
		msg1 = new String(sb);
		System.out.println(msg1);
		
		
	// [ StringBuilder ]
		//StringBuffer랑 독같음!!!!!! 새로 추가된 기능~
		//출력해보면 똑같이 출력되는 것 알 수 있음! 하하 이거로 쓰기~~
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("hello ");
		sb1.append(new Date());
		sb1.append(" java");
		sb1.append(" test ");
		sb1.append('A');
		sb1.append(" ");
		sb1.append(95);
		
		msg1 = new String(sb1);
		System.out.println(msg1);
		
		
		
		
	}

}
