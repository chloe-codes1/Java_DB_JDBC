package exercises;

import java.util.Scanner;

public class Test_leapYear {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하면 윤년인지 아닌지 알려줍니다");
		
		int year = sc.nextInt();
		boolean flag=true;
		if (!(year%400 ==0 || year%4==0 && year%100!=0)) {
			
			flag=false;
		}
		System.out.println(flag);
		
	}

}
