package day14_interface;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) throws CloneNotSupportedException {

		int[] num = {11,22,33,44,55};
//		int[] num2 = num;
		
	// [ .clone() ]
	//  : 객체를 복제할 때 사용
		int[] num2 = num.clone();
		num2[2] =0;
		
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(num2));
		// num과 num2는 같은 곳을 바라보고 있으므로 num2 값을 바뀌면 둘다 바뀐다
			//-> num.clone()으로 바꾸자 num2값만 바뀜!
			//-> why? num을 복제한 data가 num2에 저장되어서!
	
		
		System.out.println(num);
		System.out.println(num2);
		//주소 또한 서로 같다
			//-> num.clone()으로 바꿔서 주소 또한 바뀌었음!
		
		System.out.println("----------------------------");
		
		Point p = new Point(5,5);
//		Point p2 = p;
		
		
		Point p2 = p.clone();
		// -> Point class에 Cloneable을 implements 하고, clone() method를 override 해서 Point class에서도 .clone() 사용할 수 있게 됨!
		
		
		//x의 좌표를 0으로 바꿈
		p.setX(0);
		
		
		System.out.println(p);
		System.out.println(p2);
		//p의 주소가 p2로 들어가는 것이므로 같은 주소를 바라봄 -> 같은 내용 출력됨!
			//-> p.clone()으로 바꾸자 p2값만 바뀜!
			//-> why? p의 원본이 아닌, p를 복제한 data가 p2에 저장되어서!
		
		
	}

}
