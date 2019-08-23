package day01;

import java.util.Date;

class Sample_02 {
	public static void main(String[] args) {

		java.util.Date now = new java.util.Date(); // full path를 써야 Date 실행 할 수 있음 => import java.util.Date; 하면 더 간단함!!!

		// Date now = new Date(); => import 하면 이렇게만 써도 됨!

		System.out.println(now);

		Date d; // import한 util에서 가져온 Date Class
		java.sql.Date s; // sql package에서 가져온 Date Class 표현
		// -> 이렇게 안쓰면 어떤 Date Class인지 구분하기 힘들어서 따로 구분해서 쓴거임!!!
	}

}
