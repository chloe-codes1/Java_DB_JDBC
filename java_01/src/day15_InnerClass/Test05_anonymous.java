package day15_InnerClass;

import javax.swing.JOptionPane;

public class Test05_anonymous {

	public static void main(String[] args) {
		
//		Command cmd = null;
//		cmd.exec();
		// -> 이 상태로 동작하면 null point exception 발생함
		// -> 적합하지 않다!
		
		
		Command cmd1 = new DeleteCommand();
		cmd1.exec();
		// -> DeleteCommand에서 만들어서 오는거임
		// -> DeleteCommand만 수행 가능
		// -> 하나의 기능밖에 하지 못하는 함수라 효율적이지 않고, Low coupling이 아니다
		// -> 적합하지 않다!
		
		//그래서 Anonymous Inner Class사용!!
		
	// [ Anonymous Inner Class ]
		
		//class를 정의하면서 막바로 객체를 생성하는 방식
		// -> new와 Command() 사이에 class name과 Command class를 implements한다는 내용 등등 다 생략되어있는 것!
		// -> 이름 없는 anonymous class
		// -> anonymous class는 re-use 가 안된다!!
		//    => 단 한번만 사용되는 객체들은 anonymous inner class를 사용하면 유용
		// -> 객체지향을 위반 한 것
		
		
		Command list = new Command() {
			@Override
			public void exec() {
				
				System.out.println(" *** list *** ");
			}
		};
		
//		list.exec(); //->JOptionPane으로 바꾸고 주석처리함~
		
		Command update = new Command() {
			@Override
			public void exec() {
				
				System.out.println(" *** update *** ");
			}
		};
//		update.exec();
		
		Command insert = new Command() {
			@Override
			public void exec() {
				
				System.out.println(" *** insert *** ");
			}
		};
//		update.exec();
		
		Command delete = new Command() {
			@Override
			public void exec() {

				System.out.println(" *** delete *** ");
			}
		};
//		update.exec();
		
		
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