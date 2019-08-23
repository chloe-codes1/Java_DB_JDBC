package day10;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {

	// [ arraycopy를 이용한 delete 작업 ]
		
		//문자열을 char의 배열로 만들어
		char[] c = "ABCDEF".toCharArray();
		
		//배열의 길이
		int count = 6;
		
		//삭제하는 것 위치
		int d = 5;  //-> d는 5가 가장 마지막 자리임!
		
		System.out.println(Arrays.toString(c));
		
		System.arraycopy(c, d+1, c, d, count-d-1);
		//여기에서 d가 0이어도 d+1이라서 6이 되므로 에러 날것이라고 생각 할 수도 있지만, 맨마지막 count-d-1이 0이 되므로 에러 없음~
		
		c[--count]=' ';
		//삭제했으니 count가 줄어들었으니 --작업을 하고 ' '을 집어넣어~~
		
		System.out.println(Arrays.toString(c));
		
		
	}
}
