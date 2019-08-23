package day08;

public class Card {
	
	// instance 자원
	String kinds = "credit card, debit card";
	int number;
	
	// static한 자원 -> 모든 카드에 적용되는 공유 데이터니까!!!!!!
		// => memory에 떠있기 때문에 new 안해도 됨!
	final static int WIDTH = 100;
	final static int HEIGHT = 250;
	
	
	public static void main(String[] args) {
		//Card.width=0; //카드의 width를 0으로 바꾸자, 모든 카드의 width가 0으로 출력됨!
			//=> 그래서 width와 height를 수정 불가능한 final 처리 하자, 위에 문장 에러 뜸! -> 상수화 처리해서 못바꾸게 막았으니까!
				// => final keyword!
				// => *** 상수화 처리 ***
		
		System.out.println(WIDTH + " * " + HEIGHT);
			// => static에 올라가 있기 때문에 new keyword 없이 바로 출력 가능!!
		
		//System.out.println(kinds);
			//=> 이건 instance한 자원이라 에러 뜸 -> instance한 자원은 new 해야 사용 가능하다!
		
		System.out.println(new Card().kinds);
			//-> new로 memory에 띄웠기 때문에 쓸 수 있다
	}
}
