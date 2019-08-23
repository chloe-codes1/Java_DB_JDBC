package day06;

public class Test04 {

	public static void main(String[] args) {
		
	// 기존의 주소들을 배열에 담기
		// -> 배열에 담으면 주소로 관리하기 편해서!
		
		Employee emp1 = new Employee();
		emp1.setAge(25);  
		emp1.setName("김주현");
		emp1.setDept("영업부");
		emp1.setSingle(false);
		
		Employee emp2 = new Employee();
		emp2.setAge(27);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		emp2.setSingle(true); 
		
		Employee emp3 = new Employee();
		emp3.setAge(31);  
		emp3.setName("고길동");
		emp3.setDept("영업부");
		emp3.setSingle(false);
		
		
	//배열의 선언-생성-초기화 한번에 함
		Employee[] emp = {emp1, emp2, emp3}; 
		
		System.out.println("======== 영업부에 근무하는 사원 목록 ========");
		
		double sum=0;
		int count=0; //변수를 for문 밖에서 선언 해야 for문 안에서 0으로 계속 초기화 되지 않음
		
		for(Employee data : emp) { //새로운 for loop -> 접근하는 범위를 알아서 처리해줘서 더 안전함
									//접근 범위를 잘못 설정하면 예외가 발생하기 때문!
			//System.out.println(data.getDept()); //어떤 부서들 있는지 알아보려고
			
			if(data.getDept() !=null && data.getDept().equals("영업부")) {
				//[null check도 포함된 조건문]
				//-> 하지만 만약 getDept() 중에 null data가 있으면 오류가 뜸! (null인 경우에 dot연산자를 쓰면)
				//-> 그래서 조건을 달아줘야함
					//***null check***
					//=> ex) if(emp[i].getDept != null) -> null check는 equals() 함수가 아니라 == 쓴다!
					//null check가 .equals() 보다 앞으로 와야함! 그래야 걸러줄 수 있음!
				sum+=data.getAge();
				//sum+=emp[i].getAge();
				count++;
				
				data.display(); // 모든 데이터 다 찍어라
				//emp[i].display();
			}
		}
		
		System.out.printf("영업부 평균 나이 = %.2f %n", sum/count);
		
		System.out.println("====== 20대인 사원 목록 =====");

		for(int i=0 ; i < emp.length ; i++) {
			
			if(emp[i].getAge()>=0 && emp[i].getAge() < 30) {
				emp[i].display();
			}
		}
		
		System.out.println("======== 싱글인 사원 목록 =======");
		
		for(int i= 0 ; i< emp.length ; i++) { //전통적인 for loop
			
			if(!(emp[i].isSingle())) { //boolean 은 is____
				//영업부인지 확인하고 싶은데 String이라서 ==이 아니라 .equals() 함수 씀! 
				
				emp[i].display();
			}
		}
	}
}
