package day14_ex;

public class ShapeTest {

	public static void main(String[] args) {

		//data type으로 Shape 외에 Object는 가능하지만, Resizable은 RectTriangle의 부모가 아니기 때문에 불가능!
		Shape[] shapes = {
				new Rectangle(5,6),
				new RectTriangle(6,2)
		};
		

		// [ ver1. instance of & 새로운 for문 사용 ]
		
		for(Shape data: shapes) {
			System.out.println("area: " + data.getArea());
			
			// [ instanceof 연산자 ]
			// : 기재된 type이 맞다면 true 아니면 false
			if(data instanceof Resizable) {
				((Rectangle)data).resize(0.5);
				System.out.println("new area: " + data.getArea());
			}
		}


		// [ ver2. numsides & 새로운 for문 이용 ] 
		
		for(Shape data: shapes) {
			System.out.println("area: " + data.getArea());
			if(data.getNumSides()==4) {
				
				((Rectangle)data).resize(0.5);
				System.out.println("new area: " + data.getArea());
			}
		}
		
		
		// [ ver3. numsides & 전통적 for문 이용 ]
		
		for(int i=0 ; i<shapes.length ; i++) {
			System.out.println("area: " +shapes[i].getArea());
			
			if(shapes[i].getNumSides()==4){
				 ((Rectangle) shapes[i]).resize(0.5);
				System.out.println("new area: " + shapes[i].getArea());
			}
		}
	}
}
