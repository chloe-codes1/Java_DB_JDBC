package day03_ex;

import java.util.Scanner;

public class BookApp_2 {

	public static void main(String[] args) {
		
	//[Switch 쓰기]
		
		Scanner sc = new Scanner(System.in);
		
		int order;
		String output=" ";
		
		do {
				System.out.println("******** 명령 선택 *********");
				System.out.println();
				System.out.println("1. insert(등록)");
				System.out.println();
				System.out.println("2. delete(삭제)");
				System.out.println();
				System.out.println("3. update(수정)");
				System.out.println();
				System.out.println("4. quit(종료)");	
				System.out.println();
				System.out.println("*************************");
				System.out.println();
					
				
		System.out.println("수행할 명령을 선택하세요 \n1 2 3 4 중 하나를 선택하세요..");	
		
		order = sc.nextInt();
		
			switch(order)
			{
			case 1:
				output = "등록";
				break;
			case 2:
				output = "삭제";
				break;
			case 3:
				output = "수정";
				break;
			case 4:
				System.out.println("종료합니다.");
				
				sc.close(); 
				sc = null;
				
				return;	
				
			default:
				break;
		
			}
			
			if(order == 1 || order == 2 || order ==3) {
			System.out.println(output + " 작업을 수행합니다.");
			
			}
			
		}while(order != 4);
	}		
}
