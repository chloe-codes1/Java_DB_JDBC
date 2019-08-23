package day14.tv;

public class TVTest {

	public static void main(String[] args) {

//		Stv user = new Stv();
		//user로는 Stv만 제어 가능
		// -> 강력한 구조
		// -> 강력한 coupling
		//     => low coupling 일수록 좋으므로 바꿔야함!
		
		//호환이 되게하는(양쪽 모두 지원 되는) 기능 필요
		// -> interface 사용!
		
//		TV user = new Stv();
		// -> TV를 interface로 바꾸어서 Stv와 Ltv가 implements 하게 함!
		
		// -> user로 Stv와 Ltv의 method들을 모두 동작 할 수 있게됨
		// -> [ low coupling ]
		//     : 클래스간의 상호 의존 정도가 낮은 것
		
//		user.powerOn();
//		user.powerOff();
		
		
//		user= new Ltv();
//		
//		user.powerOn();
//		user.powerOff();
		
		
		//Itv는 TV를 implements 하지 않고있어서 에러 뜸 
//		user = new Itv();
		
		
	//play method() test
	// -> parameter가 TV라서 모든 TV들 다 처리 가능한 것 알 수 있음
	// -> play method()는 Stv Ltv모두 처리 가능하다!	
		play(new Stv());
		play(new Ltv());
		
		
		System.out.println("------------main method 종료-------------");
		
	}
	
	//powerOn과 powerOff 를 한번에 할 수 있는 기능 play() 만들었음
	
//	public static void play(Stv tv) {
//		tv.powerOn();
//		tv.powerOff();
//	}
//
//	public static void play(Ltv tv) {
//		tv.powerOn();
//		tv.powerOff();
//}
	//두개의 play() method의 overloading 
	
	//모든 종류의 TV를 다 처리하기 위해 play() method의 parameter를 TV로 바꿈!
	// -> 이게 바로 Low Coupling 이다!!!
	// -> Java Polymorphism (다형성)
	public static void play(TV tv) {
		tv.powerOn();
		tv.powerOff();
	}
}	