package day06;

public class Test03 {

	public static void main(String[] args) {
	
	//Test02 에서 복사함
		//-> emp1.display(); 으로 출력해보려고!
		//+ Getters  & Setters 사용해보려고~!
		
		
		int num; // 데이터 타입을 이용한 변수 선언
		String name;
		
		new Employee();
		  
		new Employee().display();
			// => display() 함수를 호출함
			// 근데 이자리에 값이 들어 있지 않아서 (void type이라 -> 수행은 되지만 그 자리에 return 값이 없어서)
			// [사번 =  0, 이름 = null, 부서 = null, 기혼 여부 = false]가 출력된다
		
		
		Employee emp1 = new Employee();  
		
		//System.out.println(emp1); //이렇게 하면 emp1의 주소값을 찍음
		
		emp1.display(); //Employee.java에서 display() method를 만들었기 때문에 이거로 출력이 가능함!
					//-> this.display() 에서 this가 생략된거임!
					//*** this keyword ***
					//= 정해진 boundary안에서 통용되는 것
					//=> 어떤 데이터가 heap영역에 생성이 되었을 때 heap영역 안에서만 사용 가능한 것!!!!!!!!
					//=> 그래서 this keyword는 stack영역에서 사용 할 수 없다!!! -> 쓰면 에러남~
			
		Employee emp2 = new Employee();
		//emp2.age =201901;   
		emp2.setAge(27); // Employee.java에서 set Age() method를 만들었기 때문에 사용 가능하다
								// age 정보를 쓸 수 있는 method를 호출함!
								// 괄호() 안에는 나이를 입력하면 된다!
		//emp2.name = "홍길동";		
		emp2.setName("홍길동"); //위에 문장이 Set method로 이렇게 표현된거임!
		//emp2.dept ="인사부";
		emp2.setDept("인사부");
		
		emp2.setSingle(true); // boolean type은 입력하지 않으면 default 초기화가 되서 false로 뜸!
							//method 선언부에서  Boolean으로 선언되었기 때문에 그 외의 type을 입력하면 오류 뜬다!
		emp2.display();
		
		
		Employee emp3 = new Employee();
		//emp3.age = 201902;
		emp3.setAge(31);
		//emp3.name =  "고길동";  
		emp3.setName("홍길동");
		//emp3.dept = "영업부";
		emp3.setDept("영업부");
			//=> write 작업이 제한 됨 (접근 제한자 private으로 인해 hidden 설정 되서)
		emp3.setSingle(false);
		emp3.display();
			//=> hidden 되었어도 display() 함수로 인해 read 는 가능 
	}
}
