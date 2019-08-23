package day13_interface;

public class SingletonTest {

	public static void main(String[] args) {
		//밑에 클래스가 있어서 new로 띄울 수 있음 -> 있었다가 access modifier 바꿔서 안됨
		//Singleton s = new Singleton();
			//위에 코드 에러남
			//-> why? Singleton class의 기본 생성자를 private으로 바꿔서!
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
	}
}

class Singleton {
	private static Singleton s = new Singleton();
	// 이 클래스 안에서만 쓸거라서 private, share의 개념이 들어가므로 static

	//Singleton -> 하나의 data memory에 띄워놓고 계속 사용할꺼야
	
	//기본 생성자 함수가 만들어져 있음
	private Singleton() {
		System.out.println("Singleton() 객체생성");
	}
	  //Access Modifier를 private으로 바꾸자, 위에 s에 에러남
	  //why? 기본 생성자가 private하기 때문에 Singleton class 외부에서는 생성이 암됨!
	
	public static Singleton getInstance() {
	//Singleton class를 private 설정해놨기 때문에 객체 생성이 불가능
	//-> 그래서 이 함수를 static처리해서 memory에 띄워 놓는다!
	//-> 이렇게 해서 main method에서 new를 쓰지 않아도 Singleton.getInstance를 호출 할 수 있음!
	
		//return new Singleton();
		//-> 이렇게 하면 이 함수로 객체 생성 할 때마다 기본 생성자가 호출됨 
		
		if(s==null) s = new Singleton();
		//null일때만 이니까, s가 없을 때 생성자를 만들고, 그 이후에 객체가 생성 될 때에는 s라는  하나의 객체에 생성자를 공유하려고 
		return s;
	}
}