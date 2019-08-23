package day15_InnerClass;

import day14_interface.Circle;
import day14_interface.Point;

public class Test01_clone {

	public static void main(String[] args) throws CloneNotSupportedException {

	// [clone() 사용하여 복사하기 ]	
		
		Point p1 = new Point(5,5);
		Point p2 = p1.clone();
		// ->.clone() method 사용하여 복사함
		
		p2.setX(0);
		// -> p2의 x좌표를 0으로 바꿈
		
		System.out.println(p1); //원본은 그대로 출력
		System.out.println(p2); //x를 setX로 바꾼 좌표 출력
		
		
		Point p3 = p2;
		// -> 복사가 아니라 같은 주소
		
		System.out.println(p3); //p3는 p2와 같은 주소를 바라보고 있으므로 p2와 같은 좌표 출력
		
		System.out.println("=======================================");
		
		
		Circle c1 = new Circle(new Point(7,7),2);
		Circle c2 = c1.clone();
		c2.setRadius(0);
		// -> radius는 double, 즉 primitive data type이라 clone이 문제 없이 됨
		
		c2.p.setX(0);
		// -> Point p 정보는 c1과 c2 모두 서로 같은 p의 주소를 바라보고 있어서 처음에 c1,c2 둘 다 바뀌었지만,
		// -> Circle class의 clone() method의 바디부를 수정하여 제대로 출력되게 함!
		
		System.out.println(c1);
		System.out.println(c2);
		
		
		//day14_interface.Circle.java 에서 복사해 온 clone() method
		// -> 원래 여기에 있으면 안됨! 그냥 보려고 복사 해온 것!
		
//		public Circle clone() throws CloneNotSupportedException {
//			//-> 복제하다가 문제 발생 할 수 있다고 알려주는 문장
//			//-> clone이 다 되는게 아니라고 알려주는 것! clone이 안될 시에 문제가 생길 수 있다~ 경고한다~~
////			return (Circle)super.clone(); //-> 원래 이 코드였는데 바꿈	
//			
//		// -> Test01에서 쓰려고 p 자원도 복제 할 수 있도록 코드 바꿨음!
//			Circle c = (Circle)super.clone(); //-> c에다가 clone을 넣음
//			Point p = c.p.clone(); //-> p에 복제한 c의 복제한 p값을 넣음
//			c.p = p; //-> c의 point에 복사한 p값을 넣음
//			return c;
//			// -> [ Deep Cloning ]
		
	}
	

}
