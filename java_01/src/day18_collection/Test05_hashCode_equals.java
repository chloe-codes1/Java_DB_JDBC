package day18_collection;

public class Test05_hashCode_equals {

	public static void main(String[] args) {

	// Test04의 hashCode() & equals() 확인용	
		
		Employee e1 = new Employee(2017001, "홍씨", "영업부");
		Employee e2 = new Employee(2017001, "김씨", "영업부");
		
		System.out.println(e1.equals(e2)); // true
		  // Test4에 hashCode()와 equals()를 number만 비교하는것으로 바꿔놓아서 같다고 나옴!
		System.out.println(e1.hashCode()); // 2017032
		System.out.println(e2.hashCode()); // 2017032
		  // hashCode도 둘다 같은 것 출력됨!
	}
}
