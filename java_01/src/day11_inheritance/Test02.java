package day11_inheritance;

public class Test02 {

	public static void main(String[] args) {
		
	//모든 자식 type을 부모 type인 Person[]의 배열에 넣을 수 있다!	
		Person[] p= { 
		 new student("홍길동", 20, 200201),
		 new teacher("이순신", 30, "JAVA"),
		 new employee("유관순", 40, "교무과")
		};
		
		//student type객체로 a1이 있을 때
		//-> 이렇게 변수 a1에 넣는 이유는 나중에 다시 쓰려고!
		//-> 위에 배열 안에 선언된 것처럼 new로만 하면 다시 호출할 수 없음!							
		student a1 = new student("김주현", 25, 1995);
		
		//부모 Person() 영역의 자원에 접근할 때에는 바로 접근 가능하다
		//-> 부모 type으로 서로 다른 자식 type들을 한번에 handling 가능하다!
		
	// [ Data type으로 부모 type을 선언할 시 장단점 ]
		//장점: handling 할 수 있는 data type이 많다 (부모+자식들)
		//단점: 접근 할 수 있는 data가 제한적이다 (자식 영역은 접근 할 수 없으므로!)
	
		
		for(Person data: p) {
			data.printA();
			System.out.println();
		}
		System.out.println("================================");
		
		
		
	// [ Down Casting ]
		//자식 영역의 자원에 접근할 때에는 다운 캐스팅 필요!
		//-> **이때, 반드시 하단부에 어떤 객체가 바인딩 되어 있는지 type check 필요**
		//-> why? 컴퍄일 되면서 확인 할 수가 없음!  => 그래서 instanceof 쓴다!
		for(Person data:p) {
			
	// [ instanceof 연산자]
	//=> down casting이 가능한지 확인 해주는 연산자 -> type checking을 해줌
			
			//여기 3줄은 print() method를 Override함으로써 지울 수 있었음
//			if(data instanceof student)((student)data).print();
//			if(data instanceof teacher)((teacher)data).print();
//			if(data instanceof employee)((employee)data).print();
			
			
			//배열 p를 Object로 만들어도 이 코드들 그대로 쓸 수 있다!
			//다만, for문 조건문에 type만 Person -> Object로 바꿔주고,
			//첫번째 for문 안에 data를 ((Person)data)으로 down-casting 해줘야함!
			
		//+ student type객체 a1은 이렇게 뽑아야함!
			//if(data instanceof student)((student)a1).print();
			
			data.print();
			//Test01에 있는 Person class와 다른 세 class들을 Override함으로써 위에 instanceof로 쓴 3문장을 이 한줄로 표현 가능함
		}
	}
}
