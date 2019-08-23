package day08;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.print();
		
		Employee emp1 = new Employee();
			//new Employee()는 기본 생성자(default 생성자)를 이용해서 객체 생성 하겠다는 뜻
		
		emp1.setName("홍길동");
		emp1.setDept("인사부");
		emp1.setSingle(true);
		
		emp1.print();
		
		//위에 처럼 각각 입력하지 않아도 되도록 Employee class에 method overloading을 이용하여 새로운 생성자 함수를 만들었음!
		Employee emp2 = new Employee("고길동", "영업부", false);
		emp2.print();

		Employee emp3 = new Employee("김길동", "영업부");
		emp3.print();
		
		Employee emp4 = new Employee("최길동", "기술부", false);
		emp4.print();
	}
}
