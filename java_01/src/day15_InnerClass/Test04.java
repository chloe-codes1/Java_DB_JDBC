package day15_InnerClass;

public class Test04 {

	public static void main(String[] args) {

	// [ interface의 활용성 ]	
		
	DeleteCommand cmd = new DeleteCommand();
	cmd.exec();	
	//-> cmd는 DeleteCommand로 data type을 설정해서 DeleteCommand의 exec() 함수만 수행할 수 있음
	
	
	Command cmd1 =  new DeleteCommand();
	cmd1.exec();
	
	cmd1 = new UpdateCommand();
	cmd1.exec();
	// -> cmd1은 Command data type이기 때문에 Command를 implements한 class들은 모두 exec() method를 쓸 수 있고,
	//    각 class가 exec() method를 override 한 내용이 출력됨
	
	// [ 정리 ]
	// -> interface를 이용하여 override가 강제시 되는 abstract method를 만들면,
	//    그 interface를 implements 하는 함수들은 해당 method를 override 하게되고,
	//    그 결과 하나의 함수명으로 각각의 class에 적합한 내용을 출력 할 수 있다!
	//       => 이게 바로 JAVA Polymorphism (다형성) 이다 !!!!	
	}
}
