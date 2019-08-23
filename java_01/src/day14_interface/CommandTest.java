package day14_interface;

import javax.swing.JOptionPane;

public class CommandTest {

	public static void main(String[] args) {
		
		Command cmd = null;
		
		String key = JOptionPane.showInputDialog("list, insert, delete, update 중 하나 입력하시오.");
		
		switch (key) {
		case "list":
			cmd = new ListCommand();
			break;

		case "insert":
			cmd = new InsertCommand();
			break;
			
		case "delete":
			cmd = new DeleteCommand();
			break;
			
		case "update":
			cmd = new UpdateCommand();
			break;
			
		default:
			cmd = new ListCommand();
			//default로 가장 기본적인 기능인 list 보여주는걸 default로 넣어놓음
			break;
		}
		
		cmd.exec();
		//method는 하나인데 어떤 작업을 선택하느냐에 따라 다른 결과값 나오게 설계함
		// -> Java Polymorphism (다형성)!!!!!!
		
		cmd.check();
		//Command에 default method로 check() 함수 만들어서 사용 가능함!
		
	}
}
