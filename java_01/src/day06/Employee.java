package day06;

public class Employee { //public -> 누구든지 참조 가능하다! import만 하면! (모두에게 열려있음)

// 이 Employee.java는 실행은 안됨 (main method가 없음)
// 그냥 하나의 Employee라는 새로운 데이터 타입을 만들어 낸 것임!
// 이런 class들을 모아서 .jar로 압축 시킨것이 library이다.
	//.jar = class들을 모아놓은 library
	//+ .war 도 있음 (web application 들을 모아놓은 것)	
		//-> Java에는 .jar와 .war가 있다!


	// Class = 데이터(변수) + 기능(함수)

	 private String name; //이름
	 private String dept; //부서 
	 private int age; //사번 ->  //201901  -> (사번으로 했다가 나중에 나이로 바꿈..)
	 private boolean single; //싱글인지 아닌지 이므로 true/false -> boolean!!
	
	// 앞에 public을 붙이면 어디서든 접근 가능함!!!
	// 앞에 private를 붙이면 해당 class 안에서는 접근 가능하지만, 그 밖에는 접근 불가! (에러 뜸)
	//-> hidden 속성이 부여됨 (Encapsulation) -> not visible!
	// 앞에 아무것도 붙지 않으면(= default) same package 안에서는 접근 가능함 
	
	
	// Method 만들기
	
	public void display() { //display 라는 method 만들었음!
		//void = return type이 없다 
			//= return 값이 없고, 자기 할 일만 하고 끝나는 것.
		    //-> return; => return뒤에 데이터가 없는 것 -> 값을 가지고 가면 안되고 그냥 return만 해야함
			//<-> return 값이 있는 것
			// ex) Math.random();, Math.PI;, .charAt(); 등등
					//=> 근데 여기서 Math. 는 주소가 아님! -> 한번 쓰고 말꺼라서 data에 띄우지도 않는다
		
		System.out.printf("[나이 = %2d, 이름 = %2s, 부서 = %2s, 기혼 여부 = %2b] \n", age, name, dept, single);
								//-> this.number, this.name, this.dept에서 this 생략됨!
								//-> 생략 되었지만 ex)'나의 member중에 name을 출력하라'로 해석하면 됨!
							// or 함수로 호출 할 수도 있음
								//-> this.getAge(), this.getName(), this.getDept(), this.isSingle
		return; //-> return; 뒤에 아무 데이터 없음!
	}
	
	
	// [ Getters Setters ]	
	// -> Access Modifier(접근 제한자) 중 private 에 접근하기 위해 Getters Setters 사용!
	
	public void setAge(int age) { //입력만 하면 끝이고 return되는 값 없으므로 void
		if(!(age>0 && age<=100)) {  // 나이 조건 달기 - 이 범위를 벗어나면 return 하도록 만들기
			System.out.println("age(나이) 정보가 잘못 되었습니다.");
			return; // return을 해줘야 잘못된 나이가 assign 되지 않음!!!!!!!!!!!
			
		}this.age = age;
			// local variable int age와 혼돈되어 에러가 나므로, 앞에 age에 this.age로 member variable임을 명시 
		return;  //void라서 return 값이 없다!
		
	}
	
	public int getAge() { // age는 int type이므로 int
		return age; // age정보를 return해준다
	}
	
	public void setName(String name) { //name을 setting하기
										//setter() 함수의 선언부
										//-> ***선언부를 통해 data type을 알 수 있기 때문에 함수 선언부는 중요하다!***
		if(!(name.length()>1)) {
			System.out.println("name(이름) 정보가 잘못 되었습니다.");
			return;
		}this.name = name;
		return;
	}
	
	public String getName() { //get___() 함수는 return만 함!
		return name;
	}

	public void setDept(String dept) {
		this.dept = dept;
		return;
	}
	
	public String getDept() {
		return dept;
	}

	public boolean isSingle() {  // *** boolean type만 setSingle 아니고 isSingle!!! ****
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}
}