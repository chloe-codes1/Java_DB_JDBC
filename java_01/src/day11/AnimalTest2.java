package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest2 {

	public static void main(String[] args) {

		
	Animal[] animals = {
		new Dog("진돗개", "쫑이"), 
		new Dog("시베리안허스키", "케리"),
		new Fish("구피")
		};
	
//	for(Animal data: animals) {
//		
//		data.breath();
//		data.print();
//		
//	}
	
		//위에 코드들 대신에 밑에 만든 call() method로 Dog type 출력하기
		Dog a1 = new Dog("진돗개", "쫑이");
		callD(a1);
		
		Fish a2 = new Fish("구피");
		callD(a2);
		
		callD(animals[0]);
	
	}

	
	//Method Overloading -> 다른 data type의 Parameter라서 가능!
	
	//Dog type 의 parameter
//	public static void callD(Dog d) {
//		d.breath();
//		
//	}
	
	//Fish type 의 parameter
//	public static void callD(Fish d) {
//		d.breath();
//		
//	}
	// -> 주석 처리한 이유: breath()가 Overriding 된 method라서 Animal로 호출해도 자식인 Fish type의 breath()도 호출해줌!
	
	//Animal type의 parameter
	public static void callD(Animal d) {
			//Animal type의 객체 다 올 수 있음 -> Animal, Dog, Fish 모두!!!!!!!
			// *** Polymorphism (다형성) ***
			// : method는 하나인데 여러가지 type의 객체를 받아서 처리할 수 있는 것
			//  -> JAVA의 특징 중 하나
		
		d.breath();
		
	}
}
