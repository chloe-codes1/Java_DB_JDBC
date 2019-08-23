package day02_ex;

public class practice_myself {

	public static void main(String[] args) {
		int a = 4;
		double b = 6.2;
		double sum = a+b;
	
		System.out.println("a + b = " + sum);
		
		System.out.printf("a + b = %4.1f %n",sum);  //내 답
		
		System.out.printf("a + b = %4.1f %n", (double)a + b);
		
		
		
		// 이건 그냥 나 %소수점 연습한거...
		double f = 10000.00;
		System.out.printf("double f = %5.1f", f);
		
	}

}
