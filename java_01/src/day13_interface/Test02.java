package day13_interface;

public class Test02 {

	public static void main(String[] args) {

		Point p = new Point(3, 3);
		System.out.println(p); // p.toString()
		// p.toString() 으로 바뀌고 toString이 호출 됨! -> 좌표 찍으면 자동으로 toString 붙음
		// 객체를 presentation 해주는 용도의 함수
		// => to.String() Method!!!

		Circle2 c1 = new Circle2();
//		System.out.println(c1); //c1.toString()
		// 기본 생성자로 생성하면 점의 정보가 null로 출력됨  
		//-> 나중에 Circle2의 기본생성자에 'p = new Point(0,0);' 로 바꿔서 0,0 출력됨

		c1.setP(p); 
		//Circle2에 만들어놓은 setP method 활용
			//set method를 통해 point의 값을 변경 가능
			// -> [ 느슨한 관계 ] 
			// --> 값을 뺐다가 넣었다가 하기가 쉬운 관계
		System.out.println(c1);

		//Circle2에 새로운 Point를 생성해서 Point가 찍는 좌표(x,y) 값을 바꿈!
		Circle2 c2 = new Circle2(new Point(7, 7), 5);
		System.out.println(c2);

	}
}