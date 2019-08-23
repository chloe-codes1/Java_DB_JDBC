package day03;

public class Test05 {

	public static void main(String[] args) {

	// 1~100 합
		//1 + 2 + 3 +  .... + 100 = ?
		
		int sum=0, sum4=0;
		for(int i=1 ; i<=100 ; i++) {
			
			sum += i;  //-> sum=sum+i;
			
		//1~100 중에 4의 배수만 더하기
			if(i%4==0) { 
				sum4+= i;
				
			}
		} 
		
		System.out.println("1~100 합계 = " + sum);
		
		System.out.println("1~100 중 4의 배수의 합계 = " + sum4);
		
	}
}
