package day07;

import java.util.Arrays;

import util.MyUtil;

public class MyMathTest {

	public static void main(String[] args) {
		
		System.out.println(MyUtil.add(33, 99)); 
		System.out.println(MyUtil.add(33.3, 99.9));
		System.out.println(MyUtil.add(33.3, 99.9, 90));
		System.out.println(MyUtil.add(1,2,3,4,5,6,7,8,9,10));
		
		System.out.println(MyUtil.add(new double[] {1,2,3,4,5,6,7,8,9,10}));
		
		
		double[] d = new double[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(d));
		//Arrays.toString()이 바로 이름은 같지만 매개변수의 type이 다르면 구분이 가능하게 한 Method Overloading의 예 
		
		
		//[ 오토박싱 언박싱 ]
 		int i=100;
 		//Integer ii = new Integer(100); -> 원래 이렇게 써야하는 것을 오토박싱 언박싱이 아래처럼 처리해줌
 		Integer ii = i;
 		i = ii;
 		 //위에 두 줄이 오토박싱 언박싱 -> 알아서 기본형을 필요하면 객체로, 객체는 기본형으로 바꿔주는 기능
 		System.out.println(i + " " +ii);
		
	}

}
