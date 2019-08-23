package day03_ex;

import java.util.Scanner;

public class BookApp_answer {

	public static void main(String[] args) {

		// [선생님 답!!!]
		// 분기 구문이 많을때는 Switch 구문이 적절해서 선생님은 Switch 구문으로 풀음~!!

		Scanner scanner = new Scanner(System.in); // 만들어 놓은 Scanner를 계속 쓰려고 while문 밖으로 뺐음!
		String cmd = null; // local variable은 초기값을 설정해줘야 한다!!!

		while (true) {

			System.out.println("******** 명령 선택 *********");
			System.out.println("                         ");
			System.out.println("1. insert(등록) \n");
			System.out.println("2. delete(삭제) \n");
			System.out.println("3. update(수정) \n");
			System.out.println("4. quit(종료) \n");
			System.out.println("************************* \n \n");
			System.out.println("수행할 명령을 선택하세요 \n1 2 3 4 중 하나를 선택하세요..");

			cmd = scanner.nextLine().trim(); // .trim() => 문자열의 공백 제거!!! ****
											// => 사람들이 숫자를 입력하는게 아니라 공백 + 숫자 이렇게 입력할 수 있으니까 혹시라도 앞 뒤로 공백이 있으면 제거해주는거

			// [.trim()] => 문자열은 공백이 있을 수 있으므로 제거해주는 method
			
			//cmd = scanner.nextInt()+ " ";  // 만약 이렇게 .nextInt()로 썼다면 뒤에 공백 +" "붙이면 문자열로 바뀜
			//scanner.nextLine();  // 공백 소진을 위해 이 문장 넣음!
			
			switch (cmd.trim()) { // cmd도 문자열이라 trim 제거 가능

			case "1": // 데이터 타입 String이라서 " " 한거임

				System.out.println("insert 작업을 수행하는 기능 호출");
				break;

			case "2":
				System.out.println("delete 작업을 수행하는 기능 호출");
				break;

			case "3":
				System.out.println("update 작업을 수행하는 기능 호출");
				break;

			case "4":
				System.out.println("정말 종료하시겠습니까? Q/q 를 입력하세요");

				String quit = scanner.nextLine().trim();

				if (quit.equals("Q") || quit.equals("q")) { // 기본형이 아니라 참조형이므로 equal 연산자(==)가 아니라 .equals() 써야한다!!

					System.out.println("종료합니다.");

					scanner.close();
					scanner = null; // 종료 시킬꺼라서 더이상 Scanner 안쓰므로 자원을 반납시킴!!

					// return; //현재 함수의 종료를 의미
					// **** main함수 안에서의 return;은 종료를 의미한다!!!!!!!!! ****

					System.exit(0); // APP 종료 함수! 이걸 return; 대신 써줄수도 있음

				//} else { // 
				//System.out.println("다시 입력하세요");
			
				}
				break;  //위에 내가 한 것 처럼 else로 쓰지 않고, break; 써도 된다!
						  //=> if 구문에 굳이 else 안와도 됨~~!!

			default:
				System.out.println("잘못 입력 하셨습니다 \n수행할 명령을 선택하세요 \n1 2 3 4 중 하나를 선택하세요..");
				break;
			}
		}
	}
}
