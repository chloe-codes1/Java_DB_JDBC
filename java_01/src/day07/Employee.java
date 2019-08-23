package day07;

/**
 * 
 * @author chloe
 * @since 07/16/2019
 *
 */
public class Employee {

	private String name; //encapsulation 하기  => private 붙이기
	private String dept;
	private boolean single;
	
	//[ 생성자 함수 ]
		//: 객체 생성과 동시에 호출되는 함수!!!!!!!
		//초기화 작업을 주로 한다. (항상 호출되기 때문에)
		//객체가 생성될 때 마다 생성자 함수는 내부에서 system(JVM)에 의해 자동으로 호출 됨
	
		//class 생성 할 때 따로 언급하지 않으면 JVM에 의해 생성자 함수가 자동으로 만들어짐
		//내가 생성자에 대해 관여하기 시작하면 전혀 관여하지 않음!
	
	public Employee() { //API로 만들어본 결과, 이런 함수 만든적 없는데 만들어져 있음 - 이미 가지고 있음
						//=생성자 함수!
		
		//여기서 초기화 작업을 함!
		System.out.println("Employee() call");
		name ="사원명";
		dept = "000 부서";
		single = true;
	}
	
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
		
		System.out.printf("[사원명 : %s, 근무부서 : %s, Single : %b] \n", name, dept, single);
	}
}