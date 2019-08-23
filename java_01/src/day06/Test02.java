package day06;

public class Test02 {

	public static void main(String[] args) {
	
	// 클래스 정의 + memory에 allocate
		
		int num; // 데이터 타입을 이용한 변수 선언
		String name;
		//Employee emp; // -> 에러남 => java 컴파일러는 Employee.라는 class를 찾는데 없고, import가 걸려있지도 않기 때문!
		 //-> 그래서 Employee라는 class를 day06 package안에 만들었음
		 //-> Employee class를 만듬으로써 새로운 data type 하나가 만들어진것임!
			//=> class는 붕어빵 틀 같은 역할!
	
		// 객체(object) 생성 (= instance 생성) - heap 영역에 띄우는 것
		 //-> 하드디스크에 있는 데이터를 new keyword를 이용하여 heap영역에 띄우는 것
		
		//instance variable
			//-> 꼭 new 해서 heap영역에 띄워서 써야하는 변수
		
		new Employee();
		 // -> temporary 객체 
		 // => memory에 Employee를 띄움 (띄우기만 하는 것!)
			//=> 여기서도 dot 쓸 수 있다! ex) new Employee().name;  
		
		
		Employee emp1 = new Employee();  //new로 heap영역에 올림 => 객체 생성
			// -> reference type
		
		// (같은 패키지 안에 만들어져 있는 Employee clss에는) data로 number, name, dept가 있음 (member들)
		// 여기 number, name, dept는 Object다! (=instance 자원) -> instance variable
		// 그래서 default 초기화가 이루어짐
		// local variable이 아닌, member variable 이기 때문
			//-> member variable은 default 초기화가 일어난다!
		
		//emp1 안에서는 "this" 라는 keyword를 쓸 수 있다!!
			//-> this는 '나'를 지칭 ex) 나의 number, 나의 name, 나의 dept
			//this로 자기자신을 의미하여 쓸 수 있다
			//this키워드는 heap영역에서만 사용 가능!!
		
		//System.out.println(emp1); //이렇게 하면 emp1의 주소값을 찍음
		//System.out.println(emp1.age + " : " + emp1.name + " : " + emp1.dept);
			//emp1.number => emp1에 있는 number 데이터 출력
			//0 : null : null  -> 입력된게 없어서 초기값이 출력됨!
		
		Employee emp2 = new Employee();
		//emp2.age =201901;   //여기서는 dot 못 씀 => 기본형이라서!!!!!
		//emp2.name = "홍길동";		// dot 쓸 수 있음  => String은 reference type이라서 가능
		//emp2.dept ="인사부";
		//System.out.println(emp2.age + " : " + emp2.name + " : " + emp2.dept);
		
		Employee emp3 = new Employee();
		//emp3.age = 201902;
		//emp3.name =  "고길동";
		//emp3.dept = "영업부";
		//System.out.println(emp3.age + " : " + emp3.name + " : " + emp3.dept);
		
		//System.out.println(emp3.dept.charAt(0)); //"영"  출력됨 -> 이게 바로 return값 => return 값이 있다!
	}
}
