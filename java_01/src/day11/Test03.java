package day11;

public class Test03 {

	public static void main(String[] args) {
		// *Data type으로 접근 가능 범위 설정*
		// *new keyword로 class loading!!*
		
		Person p = new Person ("고길동", 30);
		//p는 down-casting이 불가능하다  => person 밑에 아무것도 없기 때문
		
		Person s = new student ("홍길동", 20, 201901);
		//s는 down-casting이 가능하다! => person 밑에 student가 있기 때문
		
		employee e = new employee("유관순", 40, "교무과");
	
		Object o =  new teacher("이순신", 30, "JAVA");
		
		Object msg = new String ("Hi there");
		

		p.printA();
		System.out.println();
		
		//Person s를 student로 down-casting 하기
		((student)s).print();
		
		e.print();
		e.printA();
		System.out.println();
		
		((teacher)o).print();
		((teacher)o).printA();
		
	}
}
