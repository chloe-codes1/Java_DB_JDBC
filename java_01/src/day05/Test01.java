package day05;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		
		
	// [ 배열 ]	
		
		int num1 = 99;
		int num2 = num1;
		
		
		System.out.println("======== Call by Reference ========");
		
		
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		
		num1= 77; //77넣었으므로 num1은 99->77로 바뀜
		System.out.println("num1 = " + num1 + " num2 = " + num2); //num1은 77로 바뀌었지만 num2는 그대로 99다!
																		//num1은 int이므로 기본형
										//===> **** call by value ****
										// : original value is not changed
		
		int[] n1 = {11,22,33,44,55};
		int[] n2 = n1;
		
		int[] n3 =  new int[n1.length];  //** 배열 n1에 있는 값을 copy하려고 n1크기만큼 공간을 만들었음
											// => int type으로 n1의 size 만큼 방을 생성해라!
		
		
		for(int i=0 ; i<n1.length ; i++) {  
			n3[i] =n1[i];			//*** 배열(array) copy!!!! ****
			
		}

		System.out.println("======== Call by Reference ========");
		
		System.out.println(Arrays.toString(n1)); //배열 전체를 직을 때 Arrays.to____()
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		
		n1[2]=0; //배열 n1의 2 위치에 있는 33값을 0으로 바꾸었음
		
		System.out.println(Arrays.toString(n1)); 
		System.out.println(Arrays.toString(n2)); //위의 num1, num2와 다름!   => n1값이 바뀌자 n2값도 바뀌었다!
													//= 이건 배열이므로 n1, n2는 주소(reference)를 가리키는거라서 n2에 출력되는 값 또한 바뀌었음 
		
													//===> **** call by reference ****
													//:calling a method with a parameter as a reference
		
		System.out.println(Arrays.toString(n3)); //이건 copy된 array이므로 원래 n1의 원본이 그대로 출력된다!!!
	}
}
