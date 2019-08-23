package day12_ex;

public class TestShape_answer {

	public static void main(String[] args) {
		Shape_answer [] shape = new Shape_answer[2];
								//객체 생성 아님! Shape_answer type의 두개의 방 (변수)를 만드는 것임
		
		
		shape[ 0 ]  = new Circle_answer("원",10);
		shape[ 1 ] = new Rectangular_answer("직사각형",10,20);
		
		for (int i = 0; i < shape.length; i++) {
			shape[ i ].calculationArea();
			shape[ i ].print();
		}
	}
}