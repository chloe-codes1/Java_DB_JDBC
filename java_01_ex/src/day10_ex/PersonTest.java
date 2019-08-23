
package day10_ex;

public class PersonTest {

	public static void main(String[] args) {

		Student a = new Student("홍길동", 20, 200201);
		
		Teacher b = new Teacher("이순신", 30, "Java");
		
		Employee c = new Employee("유관순", 40, "교무과");
		
		
		
		
		System.out.println("[출력값]");
		
		a.Print();
		b.Print();
		c.Print();
		
		
	}

}
