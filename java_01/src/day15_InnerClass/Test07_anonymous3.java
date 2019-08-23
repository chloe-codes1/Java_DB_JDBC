package day15_InnerClass;

public class Test07_anonymous3 {

	public static void main(String[] args) {
		
	// [ Anonymous Inner Class ]
	//: interface, abstract class, 일반 class에서 모두 사용 가능하다
	//   -> anonymous class는 down-casting 자체가 불가능한 class!
		
		AAA a = new AAA() {
				// -> AAA는 abstract이니까 extends keyword 생략되어 있음
			
			@Override
			void exec() {
			}
		};
	
		III i  = new III() {
				// -> III 는 interface니까 implements가 생략되어 있음
			@Override
			public void exec() {
				
			}
		};
		
		CCC c = new CCC() {
				// -> CCC는 일반 class라서 overriding의 강제성은 없지만,
				//    override가 필요하다면 anonymous class로 정의 하면서 method를 재정의 (override) 할 수 있다
				//    CCC class중 c라는 객체에서만 method 하나가 다르게 동작하길 원할 때, 이렇게 anonymous class를 활용 할 수 있다!
				//       => 일반 class에서도 anonymous class 사용 가능하다~ 는 것을 알아두기
				//           -> (주의 할 점)
				//	            : anonymous class는 재사용이 불가능하므로 down-casting이 불가능 하다! 그 점 유의해서 사용하기
			void exec() {}
		};
	}
}
abstract class AAA {
	abstract void exec();
}

interface III {
	void exec();
}

class CCC {
	void exec() {}
}