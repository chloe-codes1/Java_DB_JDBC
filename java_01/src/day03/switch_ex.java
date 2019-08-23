package day03;

import java.util.Scanner;

public class switch_ex {

	public static void main(String[] args) {
		
	//Switch 구문
		
		/*	switch(인자값) {
					->인자값에는 int값으로 promotion이 가능한 데이터 타입이 들어감  => byte, short, char, int
	
				case 조건값 1:          => 세미콜론(;) 아니고 콜론(:) 임!!!!!
					수행문; break;
				case 조건값 2:
					수행문; break;
				case 조건값 3:
					수행문; break;
				case 조건값 4:
					수행문; break;
				Default:		=> default 는 조건이 하나도 맞지 않을 때 빠져나오기 위해!
 					수행문;
		 */
		
		//[책 97p]
		// 원하는 달의 날짜 수 출력하는 프로그램
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("월(1~12)을 입력하세요.");
		int month = scan.nextInt();
		
	 //-> 여기 int를 String으로 바꿀 수도 있는데, 그러면 밑에 case 1을 case "1"로 바꿔야함~~ String이니까~
		String res;
		switch(month) // switch() 안에 byte, short, char, int type 가능
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				res = "31";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				res = "30";
				break;			//break를 각각 넣어줘야함 -> 안그럼 오류난다!
			case 2:
				res = "29";
				break;
				
			default :
				res = "몰라";
		}
		
		System.out.println(month + "월은 " + res + "일 까지 입니다.");
		
		
		// (복습)
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원하는 달을 입력하면 날짜를 출력합니다.");
		int month = sc.nextInt();
		String day; 
		
		switch(month) {
		
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = "31";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = "30";
				break;
			case 2:
				day = "29";
				break;
			default:
				day = "?";
		
		}
		
		
		System.out.printf("%d월은 %s일 까지입니다.", month, day);
		*/
		
		

	}

}
