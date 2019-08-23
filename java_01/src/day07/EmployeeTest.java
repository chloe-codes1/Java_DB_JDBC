package day07;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee emp1 = new Employee(); // 여기서 ()는 기본생성자다!
	
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		 //객체가 생성될 때 마다 생성자 함수는 내부에서 system(JVM)에 의해 자동으로 호출 됨
		
		emp1.print();
		emp2.print();
		emp3.print();
	}

}
