package day03;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		 //-> main method는 Static함
			//그래서 dos창에서 실행할 때  ex) java day03.Test03
		
	//[ if 문 ]	

		// 키보드로부터 점수를 입력받는다.

		/*
		Scanner input = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = Integer.parseInt(input.nextLine());
		
		
		input.close();
		input = null;
		
		if (!(score>=0 && score<=100)){
			System.out.println("유효하지 않은 점수입니다.");
			
		}
		*/
		
		int jumsu;
		Scanner input = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");

		//jumsu = input.nextInt(); //첫 번째만 출력함

		//jumsu = input.nextLine();
		//숫자 뒤에 enter 표시가 있어서 한 줄 전체를 출력하는 nextLine() 이 필요할 수 있음
		// but, 이건 String 이라서 오류 뜸!!

		jumsu = Integer.parseInt(input.nextLine()); // -> 그래서 Integer로 Parsing(번역)을 해줘야함!!!!
								//->input이라는 곳에 가면 nextLIne()이라는 함수가 있다~~
								//점수를 입력하면 이 자리에 들어오는거임!
									//+ nextLine에는 String이 들어간다!
									
			//parseInt도 함수이기 때문에 주소가 필요한데, 우리는 주소를 모름
			//->Static한 자원 (여기서는 method)은 우리가 주소를 모르기 때문에 무조건 class명으로 접근함 (그래서 Integer로 접근하는거임!!) 
				//=> class method라고 부름!
					//+ Static한 변수는 class variable이다~!
		
		
	//이미 점수 입력 받았으니, 자원 반납 시키기
		
		input.close(); // Scanner 다 쓰고 자원 반납 할꺼야 
		input = null;  // -> 이미 입력받은 점수는 parsing을 통해 jumsu에 입력되었으니까
		
	// 유효성 검증
		if (!(jumsu >= 0 && jumsu <= 100)) { // 입력한 점수가 명시한 범위를 벗어났을 때
			System.out.println("유효하지 않은 점수입니다.");
			
	//return 문
			return;   // 현재 수행중인 함수를 종료하고 호출한 자리로 돌아가는 문장 
							//=> main 함수의 종료를 의미.
							//-> 유효하지 않으면(if문에서 걸리면) 여기서 종료된다!
									//return = 나를 호출한 곳으로 돌아가겠다
		}

		// System.out.println("점수는 " + jumsu + " 입니다.");

		// input.nextLine(); // 이걸 치면 여러 숫자를 space 넣고 입력해도, 첫번째로 출력한 것 외에 나머지를 소진시켜줌!

		/*
		 * 
		 * if( jumsu>=80 ) {
		 * System.out.println("Pass");
		 * 	} if(!(jumsu>=80)) { //-> 이게 바로
		 *			// else => else를 써야 효율성이 높다! -> 안그럼 괜히 if구문 두번 들어가기 때문
		 * System.out.println("No Pass"); }
		 */

	// 삼항 연산식으로 표현하기

		String result = jumsu >= 80 ? "Pass" : "No Pass";
		System.out.println("점수는 " + jumsu + " 이며, " + result + " 입니다.");
/*
		
	// A, B, C, D, F 등급처리
		
		//내 답
		
		String gpa;
		if (jumsu >=90 ) {
			gpa = "A";
			
			//만약 이 {} block 안에서 변수가 선언되면, 선언된 변수는 이 안에서만 쓸 수 있음 
			  // => scope가 선언 된 것
					//[ Scope란? ]  (info from Google)
					//These variables must be declared inside class (outside any function).
					//They can be directly accessed anywhere in class.
			
		}else if (jumsu >=80 ) {
			gpa = "B";
		}else if (jumsu >=70 ) {
			gpa = "C";
		}else if (jumsu >=60 ) {
			gpa = "D";
		}else {
			gpa = "F";
		}
		
			System.out.println("점수는 " + jumsu + " 이며, " + result + ", 등급은 " + gpa + " 입니다.");
			System.out.printf("점수는 %d 이며, %s, 등급은 %s 입니다. %n", jumsu, result, gpa); 
		
		
		//선생님 답	
			if (jumsu >=90 ) {
				System.out.println("점수는 " + jumsu + " 이며, " + result + ", A 등급 입니다.");
			}else if (jumsu >=80 ) {
				System.out.println("점수는 " + jumsu + " 이며, " + result + ", B 등급 입니다.");
			}else if (jumsu >=70 ) {
				System.out.println("점수는 " + jumsu + " 이며, " + result + ", C 등급 입니다.");
			}else if (jumsu >=60 ) {
				System.out.println("점수는 " + jumsu + " 이며, " + result + ", D 등급 입니다.");
			}else {
				System.out.println("점수는 " + jumsu + " 이며, " + result + ", F등급 입니다.");
			}
			*/
		
		
//		//[과제] 삼항연산자로 처리하기
//			String grade;
//			grade = jumsu >=90 ? "A" : jumsu >=80 ? "B" : jumsu >=70 ? "C" : jumsu >=60 ? "D" : "F";
//			 //System.out.println("점수는 " + jumsu + " 이며, " + result + ", " + grade +" 등급 입니다.");
//			System.out.printf("점수는 %d 이며, %s, %s 등급 입니다.", jumsu, result, grade);
		
			
			/*
		
		//등급처리를 Switch 구문으로 하기
			
		System.out.println("*******등급처리 Switch*******");
			char c = ' ';
			
			switch(jumsu/10){ //점수를 10으로 나눈 몫으로만 계산을 해서 case 개수를 줄일 수 있음
								//=> why? 90점대를 10으로 나눈 몫은 9니까!
				case 10:
				case 9:
					c = 'A';
					break;
				case 8:
					c = 'B';
					break;
				case 7:
					c = 'C';
					break;
				case 6:
					c = 'D';
					break;
				default:
					c = 'F';
					break;
			}
			
			System.out.println("점수는 " + jumsu + " 이며, 등급은 " + c + " 입니다.");
	
		return;
		//->여기에는 return; 문장이 생략되어 있음
			// return 문장 뒤에는 쓰면 안된다!!!!
*/
	}

}
