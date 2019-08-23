package day14_interface;

public class Test01_interface {

	public static void main(String[] args) {

		Circle c1 = new Circle(new Point(4,4), 3);
		System.out.println(c1);
		
		//x,y좌표 1만큼씩 이동시키기
		c1.move(1);
		System.out.println(c1);
		
		c1.draw();
		
		//Object type으로 바꿔도 toString() method가 override 되어있어서 제대로 출력됨
		Object c2 = new Circle(new Point(1,1),2);
		System.out.println(c2);
		
		//move() method는 Circle type이어야 접근 가능한데 c2는 Object type 이므로 에러 뜸!
//		c2.move(1);
		
		//area() method는 shape에서 abstract, Circle에서 override하고 있어서 Object class 에서는 접근 불가! -> 에러뜸!
//		c2.area();
		
		
		//+ 나중에 shape이 DrawAndMove를 implements 하게 되서, Drawable과 Movable에 있는 draw() method와 move() method를 사용 할 수 있게 됨!
		//  -> 그래서 Circle type으로 down-casting하지 않고 shape으로도 가능함!
//		((shape)c2).draw();
		
		
		//Object type c2를 shape type으로 down-casting하자, area() method 사용 가능
		System.out.println(((shape)c2).area());
		
		//point(x,y) 좌표 1씩 이동시키기
		((Circle)c2).move(1);
		System.out.println(c2);
		
		
		System.out.println("---------------- Rectangular ---------------");
		
		Rectangular r1 = new Rectangular(new Point(1,1),3,4);
		System.out.println(r1);
		
		//x,y 좌표 3씩 이동
		r1.move(3);
		System.out.println(r1);
		
		//shape type으로 바꿔도 toString() method가 Circle class에 override 되어 있어서 제대로 출력됨
		shape r2 = new Rectangular(new Point(2,2),2,2);
		System.out.println(r2);
		
		//shape type의 abstract method area(); 가 rectangular에 override 되어 있어서 제대로 출력 됨!
		System.out.println(r2.area());
	
		//여기는 나중에 shape가 Drawable과 Movable을 extends하고 있는 interface DrawAndMove를 implements해서
		//shape type으로도 move() method와 draw() method를 사용할 수 있게 됨!
//		r2.move(1);
//		r2.draw();
		
		//shape type r2를 Rectangular type으로 캐스팅하자, Rectangular에 override되어있는 move() 쓸 수 있음!
		((Rectangular)r2).move(2);
		System.out.println(r2);
	
		
		System.out.println("--------------------------------------------");
		
		
		shape[] shapes = {c1,r1};
		
		for(shape data:shapes) {
			System.out.println(data);
			data.move(1);
			System.out.println(data);
			System.out.println(data.area());
			data.draw();
		}
	}
}
