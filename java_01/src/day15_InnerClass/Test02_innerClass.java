package day15_InnerClass;

	// [ inner class & outer class ]

class A{
	
	String name = "A";
	
	public A() {}
	
	//parameter가 String인 생성자를 만들었기 때문에 main에 생성된 A() 에 String type을 입력하고 출력 할 수 있음!!
	public A(String name) {
		super();
		this.name = name;
	}

	void p() {
		System.out.println("A 에서 호출");
		new B().print();
		//-> inner class B에있는 print() 함수 사용하기 위해 inner class 객체 생성 함 -> new B()
	}
	
	class B{
		
//		String name = "B"; 
		// -> outer class A의 name과 똑같은 이름의 String type의 name을 만들자, name을 찍었을 때 B가 출력됨
		// -> A의 name을 출력하고 싶을 땐 A.this.name이라고 하면 된다!
	
		void print() {
			System.out.println("B 에서 호출 " +name);// -> this.name인데 this 생략된 것  => B 출력됨
			System.out.println("B 에서 호풀 " +A.this.name); //-> 이렇게 해야 A가 출력된다! => A 출력됨
		}
	}
	
	// [ static inner class ]
	
	//static한 inner class도 있다!
	// -> static class에는 instance 자원 쓸 수 없음
	static class C{
		
		
//		void print() {
			//->instance method
			//-> static 처리함
		
		static void print() {
			System.out.println("~~~~~~~~~~");
		}
	}
	
	
	class D{
		
		void p() {
			class e{
				//inner class안에서도 class 선언 할 수 있다!
				// -> [ local inner class ]
				// -> 하지만 재활용이 어려운 class이다.			
				// -> 이 위치에서만 쓰고 버리는게 local inner class다!
			}
		}
	}
}

public class Test02_innerClass {

	public static void main(String[] args) {

		A a = new A("랄랄라"); //-> 여기에 "랄랄라" 입력하면 a.p(); 출력 시 A의 p() method가 new B().print() method를 호출해서
							//    print() method 의 출력값으로 "B 에서 호출 랄랄라"가 두 번 찍힘
		a.p(); //A class에서 호출한 p() method가  출력됨
		
		//inner class B는 B로 할 수 없고 A.B라고 해야함!
		// => outer class.inner class ___ = new outer class(). new inner class();
		
		A.B b = new A("롸").new B(); // -> 여기에 "롸" 입력하면 b.print(); 출력 시 "B 에서 호출 롸" 가 두 번 직힘
//		A.B b = a.new B();  // -> 위에 이렇게 쓸 수도 있음
		b.print();
		
		
		//class C를 static으로 바꾸기 전엔 이렇게 해야했었음
//		A.C c = new A().new C();
//		c.print();
		
		//static class의 static method는 new로 띄워서 호출 할 필요 없다
		//-> A 안에 있는 C의 print() method를 막바로 호출한다!
		A.C.print();
	}
}