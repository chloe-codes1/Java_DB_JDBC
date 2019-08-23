package day03_ex;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		// [if문 쓰기]
		Scanner sc = new Scanner(System.in);
		int order;
	
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

			
			if (order >= 1 && order <= 4) {

				if (order == 1) {
					System.out.println("등록 작업을 수행합니다.");
				} else if (order == 2) {
					System.out.println("삭제 작업을 수행합니다.");
				} else if (order == 3) {
					System.out.println("수정 작업을 수행합니다.");
				} else if (order == 4) {
					System.out.println("종료합니다.");
					
					sc.close(); 
					sc = null;
				}
			}else {} 
		}while(order != 4);
	}
}
