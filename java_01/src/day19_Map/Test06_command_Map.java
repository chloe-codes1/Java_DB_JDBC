package day19_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import day18_collection.Employee;

public class Test06_command_Map {

	public static void main(String[] args) {

		// [ Map 구조로 설계 ]

		Command_Interface delete = new DeleteCommand();
		Command_Interface update = new UpdateCommand();
		Command_Interface select = new SelectCommand();
		Command_Interface insert = new InsertCommand();

		Map<String, Command_Interface> map = new HashMap<String, Command_Interface>();

		map.put("delete", new DeleteCommand());
		map.put("update", new UpdateCommand());
		map.put("select", new SelectCommand());
		map.put("insert", new InsertCommand());
		
		// ( 기능 추가하기 )
		//  by using anonymous class
		//   -> 익명 class 생성해서 바로 method를 바인딩 시켜버림!
		map.put("new", new Command_Interface() {
			@Override
			public void exec() {
				System.out.println(" 기능 추가 ");
			}
		});

		while(true) {
		String cmd = JOptionPane.showInputDialog("insert, delete, select, update 중에 입력");

		Command_Interface command = map.get(cmd);
		if (command != null) {
			command.exec();
			break;
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
	}
	}
}
