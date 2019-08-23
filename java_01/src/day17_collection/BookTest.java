package day17_collection;

import day16_exception.Book;
import day16_exception.PriceException;

public class BookTest {

	public static void main(String[] args) {

		Book b1 = new Book();
		//default로 만든 객체라 기본 생성자 호출되고, try catch 쓸 필요 없음!
		
		b1.setTitle("JAVA");
	
		//사용자 생성 에러인 PriceException 때문에 try catch 구문으로 감쌌음
		try {
			b1.setPrice(-1000);
		} catch (PriceException e) {
			//e.printStackTrace();
			System.out.println("에러 내용: "+e.getMessage());
			System.err.println("b1 => " +e.getMessage());
			// [ System.err ]
			// : 에러 메세지 출력할 땐 이거 쓰면 원래 에러 출력되는 것처럼 빨간색으로 출력됨!
			//   -> 이것도 stream이 달라서 항상 위치가 다르게 출력이 됨!
		}
		System.out.println(b1);
		System.out.println("----------------------------");
		
		Book b2 = null;
		try {
			b2 = new Book("jsp", -10000);
		} catch (PriceException e) {
			System.err.println("b2 => " +e.getMessage());
		}
		System.out.println(b2);
	}
}
