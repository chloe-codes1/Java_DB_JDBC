package day15_InnerClass;

import javax.swing.JOptionPane;

public class Test06_anonymous2 {

	public static void main(String[] args) {
		
	// [ 람다식 ] 
	// 람다: 변수에 함수를 등록하여 사용하는 기능
	//		(변수에 값이 등록되어야 하는데 함수가 등록되는 람다!)
	//   -> abstract method가 1개일때만 사용 가능 -> 그래서 함수명을 따로 기재할 필요 없고 지울 수 있다!
	//   -> 함수형 기반을 지원하는 람다식~~
	//   -> Test05를 람다식으로 표현함! super simple

		
		
		// list라는 변수에 함수가 등록 된 것
		// -> list.exec() 이렇게 해서 list라는 변수에 등록된 함수를 호출해서 사용하는 것 => 람다식!
		Command list = 
						() -> {
								System.out.println(" *** list *** ");
								
								};
		
		
		Command update = () -> System.out.println(" *** update *** ");

		
		Command insert = () -> System.out.println(" *** insert *** ");

		
		Command delete = () -> System.out.println(" *** delete *** ");
		
		
	
	while(true) {	
		
	String msg = JOptionPane.showInputDialog("1. list  2. update  3. insert  4. delete\n1, 2, 3, 4 중 입력하세요.");
		
		switch (msg) {
		case "1":
			list.exec();
			break;
		case "2":
			update.exec();
			break;
		case "3":
			insert.exec();
			break;
		case "4":
			String AreYouSure = JOptionPane.showInputDialog("정말 종료 하시겠습니까? 종료를 원하면 Q/q를 입력하세요");
			if(AreYouSure.equals("Q") || AreYouSure.equals("q")){
				System.out.println("종료합니다.");
			delete.exec();
			
			System.exit(0); //시스템 종료 함수
			
			}
			break;
			
		default:
			break;
		}
	}
	}
}
