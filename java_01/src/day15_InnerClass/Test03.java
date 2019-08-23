package day15_InnerClass;

import day14_interface.Point;

public class Test03 {

	public static void main(String[] args) {

	// [ Inner class & Outer class 를 만들어야 하는 이유 Test ]
		
//		Inner i = new Inner(); 
		// -> is a 관계랑 has a 관계 test 했을때, 이렇게 객체 생성
		
		Outer.Inner i = new Outer().new Inner();
		// -> Outer class & Inner class는 이렇게 객체 생성!
		i.print();
	}
}

class Outer{
	
	Point p = new Point(3,3);


class Inner {
//	Outer o; //-> has a 관계로 해봤을 때
	void print(){
		System.out.println(p);
		
	}
}
}

// [ Test 요약 ]

//(is a 관계)
	//is a 관계는 single inheritance라 상속 받을 수 없는 상황이 잦음
  	//-> 신중하게 하나만 골라서 상속 받아야 하기 때문
  	//    => 적합하지 않음

//(has a 관계)
	//has a 관계는 inner class에서 Outer o; 로 선언했기 때문에 null point exception이 남
	// -> Outer o = new Outer(); 로 선언하면 null 오류는 나지 않지만 강력한 관계가 됨
	// -> 강력하게 서로 묶여있는 관계이기 때문에 수정이 힘들다 => low coupling이 아니게 됨!
	//     => 적합하지 않음 

//--> 그래서 Inner class를 생성하는 것이 적합하다!!!
