package day13_interface;

public class Test03 {

	public static void main(String[] args) {

		Circle2 c = new Circle2(new Point(5,5),3);
	
		//type을 shape , Drawable로 바꿔서도 해봤음
		//-> 단, 바꿔서 하면 각각 밑에 c.draw()와 c.area()에서 c를 Circle2로 type-casting해야함!
		
		System.out.println(c);
		System.out.println(c.area());
		c.draw();
		
		((Drawable)c).draw();
	}
}
