package day08;

/**
 * 
 * @author chloe
 * @since 07/16/2019
 * @version 1.0
 *
 */
public class Employee { //Employee class 는 data다
	static String cName="BIT";
	private String name; //encapsulation 하기  => private 붙이기
	private String dept;
	private boolean single;
	
	//[ 생성자 함수 ]
		//: 객체 생성과 동시에 호출되는 함수!!!!!!!
		//초기화 작업을 주로 한다. (항상 호출되기 때문에)
		//객체가 생성될 때 마다 생성자 함수는 내부에서 system(JVM)에 의해 자동으로 호출 됨
	
		//class 생성 할 때 따로 언급하지 않으면 JVM에 의해 생성자 함수가 자동으로 만들어짐
		//내가 생성자에 대해 관여하기 시작하면 JVM은 전혀 관여하지 않음!
	
	
	// 기본 생성자 함수
	public Employee() { //api로 만들어본 결과, 이런 함수 만든적 없는데 만들어져 있음 - 이미 가지고 있음
						//=> 기본 생성자 (default 생성자)
		
	// 생성자 함수!
		// -> 생성자 함수는 return type을 필요로 하지 않는다!
		
		//아래처럼 생성자 함수를 통해 초기화 작업을 함!
		//System.out.println("Employee() call");
		
//		this.name ="사원명"; //this 생략하고 name으로 쓸 수도 있음
//		this.dept = "000 부서";
//		this.single = true;
	
		
	// [ this() method ] => 나의 또 다른 생성자 함수를 call 하는 함수
		//this의 함수꼴은 생성자 함수 안에서만 사용 가능
		//first statement에만 허용되는 문장이다.
		//-> 생성자 함수 내 첫번째 문장이어야 함
		//-> this() 함수 앞에 다른 명령문 ex) System.out.print ~ 오면 안됨!
		
		this("사원이름", "000 부서", true); 
		//코드 중복을 방지하려고 밑에 있는 또다른 생성자의 코드를 가져오려고 this() 함수 사용함
		  //-> this() method가 밑에 있는 parameter 3개짜리 생성자 함수를 가져와서 쓰고 다시 돌려놓음			
	}
	
	// parameter 3개짜리 생성자 함수 
	public Employee(String name, String dept, boolean single) { 
		//method overloading -> parameter가 다르면 된다!!
		
		//System.out.printf("Employee(%s,%s,%b) call\n", name, dept, single);
		
		this.name = name; //this.name = 내 함수 Employee에 있는 private String name을 지칭하는 것
		this.dept = dept;
		this.single = single;
	}
	
	// parameter 2개짜리 생성자 함수
	public Employee(String name, String dept) { 
		//method overloading -> parameter가 다르면 된다!!
		
		//System.out.printf("Employee(%s,%s) call\n", name, dept);
		
//		this.name = name;
		//-> this.name = 내 함수 Employee에 있는 private String name을 지칭하는 것
//		this.dept = dept;
		
		this(name,dept,false);
			//여기서는 parameter가 2개라서 맨 마지막 boolean의 가장 기본적인 초기값인 false를 입력함
			//그래야 오류가 안나게 호출 할 수 있음
	}
	
	// ===> 이제 생성자 함수가 3개니까 EmployeeTest 실행하면 3가지 종류의 생성자가 call됨!
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public boolean isSingle() {
		
		return single;
	}
	/**
	 * @param single 미혼 여부
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}
	
	/**
	 * Employee 정보 출력
	 */

	public void print(){ //static 붙이면 에러남 -> instance 변수를 사용하므로!
		
		//System.out.println("회사명 : "+cName); //

		System.out.printf("[사원명 : %s, 근무부서 : %s, Single : %b] \n", name, dept, single);
	}
}