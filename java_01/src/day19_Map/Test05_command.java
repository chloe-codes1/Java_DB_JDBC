package day19_Map;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test05_command {

	public static void main(String[] args) {

		// [ Switch 구문 사용 ]
		
		Command_Interface delete = new DeleteCommand();
		Command_Interface update = new UpdateCommand();
		Command_Interface select = new SelectCommand();
		Command_Interface insert = new InsertCommand();

		while (true) {

			String cmd = JOptionPane.showInputDialog("insert, delete, select, update 중에 입력");

//		String cmd = args[0];

			if (cmd != null) {
				switch (cmd) {

				case "delete":
					delete.exec();
					break;
				case "update":
					update.exec();
					break;
				case "select":
					select.exec();
					break;
				case "insert":
					insert.exec();
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
					break;
				}
			}else {
				break;
			}
		}
	}
}
