package day14_interface;

// interface Command를 만들고, Command를 implements 하는 4개의 class로 각각 다른 기능을 하게 만들기 
public interface Command {
	
	
//	public void check();
	
	//-> interface에 check() 기능 하나를 추가했더니, Command를 implements하던 모든 class들에 오류 뜸
	//-> 그렇다고 check() method를 abstract으로 만들고 자식 class들에게 override 시키기엔
	//   만약 DeleteCommand class에만 이 기능이 필요하다면 다른 class들에 불필요한 작업을 하게됨!
	
	//그래서 default method로 만들었음!
	default public void check() {
		System.out.println("Command Check() 함수");
		
	}
	// [ default method ]
	// : interface안에는 abstract method이외에 default method를 추가할 수 있다!!!!
	//   -> 이건 abstract method도, instance method도 아니다!
	//   -> default method는 내부적으로 static method 처럼 관리되는 method 임!
	
	// + 이렇게 생성된 default 함수는 자식 class가 override해서 기능을 자신에 맞게 바꾸지 않아도
	//   Command class를 implements 하는 모든 class들에게 자동으로 실행 됨
	//   만약 이 check() method를 다른 자식 class 들에게 적용되지 않게 하길 원하면
	//   default method body부를 비워둔 채로 {} 하는 방법 밖에 없음!
	
	
	public void exec();
}
	// [ CRUD ]
	// C: create
	// R: read
	// U: update
	// D: delete

class DeleteCommand implements Command{

	@Override
	public void exec() {
		System.out.println("Delete 수행");
	}
		
	//DeleteCommand class에만 check() method Override 함!
	@Override
	 public void check() {
		System.out.println("Default Command Check() 함수");
			
		}	
}
class InsertCommand implements Command{

	@Override
	public void exec() {
		System.out.println("Insert 수행");
	}
}
class UpdateCommand implements Command{

	@Override
	public void exec() {
		System.out.println("Update 수행");
	}
}
class ListCommand implements Command{

	@Override
	public void exec() {
		System.out.println("List 수행");
	}
}